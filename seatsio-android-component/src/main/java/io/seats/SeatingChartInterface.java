package io.seats;

import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SeatingChartInterface {

    private final SeatingChartConfig config;

    public SeatingChartInterface(SeatingChartConfig config) {
        this.config = config;
    }

    @JavascriptInterface
    public void onObjectSelected(String object, String ticketType) {
        config.onObjectSelected.accept(
                new Gson().fromJson(object, SeatsioObject.class),
                new Gson().fromJson(ticketType, TicketType.class)
        );
    }

    @JavascriptInterface
    public void onObjectDeselected(String object, String ticketType) {
        config.onObjectDeselected.accept(
                new Gson().fromJson(object, SeatsioObject.class),
                new Gson().fromJson(ticketType, TicketType.class)
        );
    }

    @JavascriptInterface
    public void onObjectClicked(String object) {
        config.onObjectClicked.accept(new Gson().fromJson(object, SeatsioObject.class));
    }

    @JavascriptInterface
    public void onBestAvailableSelected(String objects, String nextToEachOther) {
        Type listType = new TypeToken<List<SeatsioObject>>() {
        }.getType();
        config.onBestAvailableSelected.accept(
                new Gson().fromJson(objects, listType),
                new Gson().fromJson(nextToEachOther, Boolean.class)
        );
    }

    @JavascriptInterface
    public void onBestAvailableSelectionFailed() {
        config.onBestAvailableSelectionFailed.run();
    }

    @JavascriptInterface
    public void onSelectionValid() {
        config.onSelectionValid.run();
    }

    @JavascriptInterface
    public void onSelectionInvalid(String violations) {
        Type listType = new TypeToken<List<SelectionValidatorType>>() {
        }.getType();
        config.onSelectionInvalid.accept(new Gson().fromJson(violations, listType));
    }

    @JavascriptInterface
    public void onSelectedObjectBooked(String object) {
        config.onSelectedObjectBooked.accept(new Gson().fromJson(object, SeatsioObject.class));
    }

    @JavascriptInterface
    public void onChartRendered() {
        config.onChartRendered.run();
    }

    @JavascriptInterface
    public void onChartRenderingFailed() {
        config.onChartRenderingFailed.run();
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
