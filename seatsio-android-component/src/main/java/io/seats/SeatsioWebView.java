package io.seats;

import static io.seats.SeatsioJavascriptInterface.GSON;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Consumer;

import io.seats.seatingChart.Category;
import io.seats.seatingChart.SeatsioObject;
import io.seats.seatingChart.SelectedObject;

abstract public class SeatsioWebView<T extends WebView> extends WebView {

    protected Caller caller = new Caller(this);

    protected abstract String toolName();

    public SeatsioWebView(Region region, String configJson, SeatsioJavascriptInterface javascriptInterface, Context context) {
        super(context);
        init(region, configJson, javascriptInterface);
    }

    public SeatsioWebView(Region region, String configJson, SeatsioJavascriptInterface javascriptInterface, Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(region, configJson, javascriptInterface);
    }

    public SeatsioWebView(Region region, String configJson, SeatsioJavascriptInterface javascriptInterface, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(region, configJson, javascriptInterface);
    }

    public SeatsioWebView(Region region, String configJson, SeatsioJavascriptInterface javascriptInterface, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(region, configJson, javascriptInterface);
    }

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    void init(Region region, String configJson, SeatsioJavascriptInterface javascriptInterface) {
        this.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage msg) {
                Log.println(level(msg), "seatsio", msg.message() + " -- From line " + msg.lineNumber() + " of " + msg.sourceId());
                return true;
            }

            private int level(ConsoleMessage msg) {
                switch (msg.messageLevel()) {
                    case ERROR:
                        return Log.ERROR;
                    case WARNING:
                        return Log.WARN;
                    default:
                        return Log.INFO;
                }
            }
        });
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAllowContentAccess(true);
        javascriptInterface.init(this);
        addJavascriptInterface(javascriptInterface, "Native");
        loadData(createSrc(region.getUrl(), configJson), "text/html", "UTF-8");
    }

    private String createSrc(String url, String configJson) {
        return "<html>" +
                "<head>" +
                "<script src=\"" + url + "/chart.js\"></script>" +
                "</head>" +
                "<body style=\"margin: 0; padding: 0\">" +
                "<div id=\"chart\" style=\"width: 100%; height: 100%;\"></div>" +
                "<script>" +
                "var internalCallbacks = {};" +
                "function asyncCallSuccess(requestId) { return result => Native.asyncCallSuccess(JSON.stringify(result), requestId) }" +
                "function asyncCallError(requestId) { return result => Native.asyncCallError(requestId) }" +
                "function registerInternalCallback(name, fn) { internalCallbacks[name] = fn }" +
                "function callInternalCallback(name, data) { internalCallbacks[name](data); delete internalCallbacks[name] }" +
                "let chart = new seatsio." + toolName() + "(" + configJson + ").render()" +
                "</script>" +
                "</body>" +
                "</html>";
    }

    public void onAsyncCallSuccess(String result, String requestId) {
        caller.onSuccess(result, requestId);
    }

    public void onAsyncCallError(String requestId) {
        caller.onError(requestId);
    }

    public void callInternalCallback(String name, Object data) {
        if (data instanceof Integer) {
            caller.call("callInternalCallback('" + name + "'," + data + ")");
        } else if (data instanceof String) {
            caller.call("callInternalCallback('" + name + "', '" + data + "')");
        } else {
            caller.call("callInternalCallback('" + name + "'," + GSON.toJson(data) + ")");
        }
    }

    public void findObject(String label, Consumer<SeatsioObject> successCallback, Runnable errorCallback) {
        caller.callAsync(
                "chart.findObject(" + GSON.toJson(label) + ")",
                object -> {
                    SeatsioObject seatsioObject = GSON.fromJson(object, SeatsioObject.class);
                    successCallback.accept(seatsioObject);
                },
                errorCallback
        );
    }

    public void rerender() {
        caller.call("chart.rerender()");
    }

    public void trySelectObjects(SelectedObject... selectedObjects) {
        caller.call("chart.trySelectObjects(" + new Gson().toJson(selectedObjects) + ")");
    }

    public void doSelectObjects(SelectedObject... selectedObjects) {
        caller.call("chart.doSelectObjects(" + new Gson().toJson(selectedObjects) + ")");
    }

    public void zoomToObjects(String ... labels) {
        caller.call("chart.zoomToObjects(" + new Gson().toJson(labels) + ")");
    }

    public void resetView() {
        caller.call("chart.resetView()");
    }

    public void selectCategories(String... categoryIds) {
        caller.call("chart.selectCategories(" + new Gson().toJson(categoryIds) + ")");
    }

    public void deselectCategories(String... categoryIds) {
        caller.call("chart.deselectCategories(" + new Gson().toJson(categoryIds) + ")");
    }

    public void zoomToSection(String label) {
        caller.call("chart.zoomToSection(" + new Gson().toJson(label)+ ")");
    }

    public void zoomToSelectedObjects() {
        caller.call("chart.zoomToSelectedObjects()");
    }

    public void pulseObject(String objectLabel) {
        caller.call("chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.pulse())");
    }

    public void unpulseObject(String objectLabel) {
        caller.call("chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.unpulse())");
    }

    public void listSelectedObjects(Consumer<List<SeatsioObject>> callback) {
        caller.callAsync(
                "chart.listSelectedObjects()",
                objects -> {
                    Type listType = new TypeToken<List<SeatsioObject>>() {
                    }.getType();
                    List<SeatsioObject> seatsioObjects = GSON.fromJson(objects, listType);
                    callback.accept(seatsioObjects);
                }
        );
    }

    public void listCategories(Consumer<List<Category>> callback) {
        caller.callAsync(
                "chart.listCategories()",
                categories -> {
                    Type listType = new TypeToken<List<Category>>() {
                    }.getType();
                    callback.accept(GSON.fromJson(categories, listType));
                }
        );
    }

    public void clearSelection(Runnable successCallback, Runnable errorCallback) {
        caller.callAsync(
                "chart.clearSelection()",
                object -> successCallback.run(),
                errorCallback
        );
    }
}
