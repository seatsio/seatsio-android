package io.seats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.WebView;

abstract class SeatsioWebView extends WebView {

    protected AsyncRequests asyncRequests = new AsyncRequests(this);

    public SeatsioWebView(String configJson, Context context) {
        super(context);
        init(configJson);
    }

    public SeatsioWebView(String configJson, Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(configJson);
    }

    public SeatsioWebView(String configJson, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(configJson);
    }

    public SeatsioWebView(String configJson, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(configJson);
    }

    @SuppressLint("JavascriptInterface")
    void init(String configJson) {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        addJavascriptInterface(seatingChartInterface(), "Native");
        WebView.setWebContentsDebuggingEnabled(true);
        loadData(createSrc(configJson), "text/html", "UTF-8");
    }

    abstract Object seatingChartInterface();

    private String createSrc(String configJson) {
        return "<html>" +
                "<head>" +
                "<script src=\"https://cdn-staging.seatsio.net/chart.js\"></script>" +
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
}
