package io.seats;

import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SeatingChartInterface {

    private final SeatingChartConfig config;
    private final SeatingChart seatingChart;

    private static final Type OBJECT_LIST_TYPE = new TypeToken<List<SeatsioObject>>() {
    }.getType();

    private static final Type TICKET_TYPE_LIST_TYPE = new TypeToken<List<TicketType>>() {
    }.getType();

    public SeatingChartInterface(SeatingChartConfig config, SeatingChart seatingChart) {
        this.config = config;
        this.seatingChart = seatingChart;
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
    public void onHoldSucceeded(String objects, String ticketTypes) {
        config.onHoldSucceeded.accept(
                new Gson().fromJson(objects, OBJECT_LIST_TYPE),
                new Gson().fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onHoldFailed(String objects, String ticketTypes) {
        config.onHoldFailed.accept(
                new Gson().fromJson(objects, OBJECT_LIST_TYPE),
                new Gson().fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onReleaseHoldSucceeded(String objects, String ticketTypes) {
        config.onReleaseHoldSucceeded.accept(
                new Gson().fromJson(objects, OBJECT_LIST_TYPE),
                new Gson().fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onReleaseHoldFailed(String objects, String ticketTypes) {
        config.onReleaseHoldFailed.accept(
                new Gson().fromJson(objects, OBJECT_LIST_TYPE),
                new Gson().fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
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
        seatingChart.post(() -> config.onChartRendered.accept(seatingChart));
    }

    @JavascriptInterface
    public void onChartRenderingFailed() {
        config.onChartRenderingFailed.accept(seatingChart);
    }

    @JavascriptInterface
    public String tooltipInfo(String object) {
        return config.tooltipInfo.apply(new Gson().fromJson(object, SeatsioObject.class));
    }

    @JavascriptInterface
    public String formatPrice(float price) {
        return config.priceFormatter.apply(price);
    }

    @JavascriptInterface
    public void asyncCallSuccess(String result, String requestId) {
        seatingChart.onAsyncCallSuccess(result, requestId);
    }

    @JavascriptInterface
    public void asyncCallError(String requestId) {
        seatingChart.onAsyncCallError(requestId);
    }
}
