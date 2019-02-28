package io.seats;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Consumer;

public class SeatingChart extends WebView {

    private WebView webview;
    private AsyncRequests asyncRequests = new AsyncRequests(this);

    public SeatingChart(SeatingChartConfig config, Context context) {
        super(context);
        init(config);
    }

    public SeatingChart(SeatingChartConfig config, Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(config);
    }

    public SeatingChart(SeatingChartConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(config);
    }

    public SeatingChart(SeatingChartConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(config);
    }

    public void getHoldToken(Consumer<String> callback) {
        evaluateJavascript("chart.holdToken", callback::accept);
    }

    public void zoomToSelectedObjects() {
        evaluateJavascript("chart.zoomToSelectedObjects()", null);
    }

    public void selectBestAvailable(BestAvailable bestAvailable) {
        evaluateJavascript("chart.selectBestAvailable(" + new Gson().toJson(bestAvailable) + ")", null);
    }

    public void selectObjects(SelectedObject... objects) {
        evaluateJavascript("chart.selectObjects(" + new Gson().toJson(objects) + ")", null);
    }

    public void deselectObjects(SelectedObject... objects) {
        evaluateJavascript("chart.deselectObjects(" + new Gson().toJson(objects) + ")", null);
    }

    public void listSelectedObjects(Consumer<List<SeatsioObject>> callback) {
        asyncRequests.doRequest(
                "listSelectedObjects",
                objects -> {
                    Type listType = new TypeToken<List<SeatsioObject>>() {
                    }.getType();
                    callback.accept(new Gson().fromJson(objects, listType));
                }
        );
    }

    public void listCategories(Consumer<List<Category>> callback) {
        asyncRequests.doRequest(
                "listCategories",
                categories -> {
                    Type listType = new TypeToken<List<Category>>() {
                    }.getType();
                    callback.accept(new Gson().fromJson(categories, listType));
                }
        );
    }

    public void findObject(String label, Consumer<SeatsioObject> successCallback, Runnable errorCallback) {
        asyncRequests.doRequest(
                "findObject",
                label,
                object -> successCallback.accept(new Gson().fromJson(object, SeatsioObject.class)),
                errorCallback
        );
    }

    public void clearSelection(Runnable successCallback, Runnable errorCallback) {
        asyncRequests.doRequest(
                "clearSelection",
                object -> successCallback.run(),
                errorCallback
        );
    }

    private void init(SeatingChartConfig config) {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        addJavascriptInterface(new SeatingChartInterface(config, this), "Native");
        WebView.setWebContentsDebuggingEnabled(true);
        loadData(createSrc(config), "text/html", "UTF-8");
    }

    private String createSrc(SeatingChartConfig config) {
        return "<html>" +
                "<head>" +
                "<script src=\"https://cdn-staging.seatsio.net/chart.js\"></script>" +
                "</head>" +
                "<body style=\"margin: 0; padding: 0\">" +
                "<div id=\"chart\" style=\"width: 100%; height: 100%;\"></div>" +
                "<script>" +
                "function asyncCallSuccess(requestId) { return result => Native.asyncCallSuccess(JSON.stringify(result), requestId) }" +
                "function asyncCallError(requestId) { return result => Native.asyncCallError(requestId) }" +
                "let chart = new seatsio.SeatingChart(" + config.toJson() + ").render()" +
                "</script>" +
                "</body>" +
                "</html>";
    }

    void onAsyncCallSuccess(String result, String requestId) {
        asyncRequests.onSuccess(result, requestId);
    }

    void onAsyncCallError(String requestId) {
        asyncRequests.onError(requestId);
    }

}
