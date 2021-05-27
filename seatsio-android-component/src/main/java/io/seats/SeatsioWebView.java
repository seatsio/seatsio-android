package io.seats;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.WebView;

abstract public class SeatsioWebView extends WebView {

    protected Caller caller = new Caller(this);

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
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        javascriptInterface.init(this);
        addJavascriptInterface(javascriptInterface, "Native");
        WebView.setWebContentsDebuggingEnabled(true);
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
                "function asyncCallSuccess(requestId) { return result => Native.asyncCallSuccess(JSON.stringify(result), requestId) }" +
                "function asyncCallError(requestId) { return result => Native.asyncCallError(requestId) }" +
                "let chart = new seatsio.SeatingChart(" + configJson + ").render()" +
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
}
