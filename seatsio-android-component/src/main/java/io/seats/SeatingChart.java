package io.seats;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class SeatingChart extends WebView {

    private WebView webview;

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

    private void init(SeatingChartConfig config) {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        addJavascriptInterface(new SeatingChartInterface(config), "Native");
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
                "new seatsio.SeatingChart(" + config.toJson() + ").render()" +
                "</script>" +
                "</body>" +
                "</html>";
    }

}
