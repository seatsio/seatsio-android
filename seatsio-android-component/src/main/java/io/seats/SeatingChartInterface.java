package io.seats;

import android.webkit.JavascriptInterface;
import com.google.gson.Gson;

public class SeatingChartInterface {

    private final SeatingChartConfig config;

    public SeatingChartInterface(SeatingChartConfig config) {
        this.config = config;
    }

    @JavascriptInterface
    public void onObjectSelected(String object) {
        config.onObjectSelected.accept(new Gson().fromJson(object, SeatsioObject.class));
    }

    @JavascriptInterface
    public void onChartRendered() {
        config.onChartRendered.run();
    }

    @JavascriptInterface
    public String tooltipInfo(String object) {
        return config.tooltipInfo.apply(new Gson().fromJson(object, SeatsioObject.class));
    }

    @JavascriptInterface
    public String formatPrice(float price) {
        return config.priceFormatter.apply(price);
    }
}
