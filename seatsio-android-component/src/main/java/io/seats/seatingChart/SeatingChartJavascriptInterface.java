package io.seats.seatingChart;

import android.webkit.JavascriptInterface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.seats.SeatsioJavascriptInterface;

public class SeatingChartJavascriptInterface extends SeatsioJavascriptInterface {

    protected static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Pricing.class, new Pricing.PricingDeserializer())
            .create();

    private SeatingChartConfig config;

    private static final Type OBJECT_LIST_TYPE = new TypeToken<List<SeatsioObject>>() {
    }.getType();

    private static final Type TICKET_TYPE_LIST_TYPE = new TypeToken<List<TicketType>>() {
    }.getType();

    SeatingChartJavascriptInterface(SeatingChartConfig config) {
        this.config = config;
    }

    @JavascriptInterface
    public void onObjectSelected(String object, String ticketType) {
        config.onObjectSelected.accept(
                toSeatsObject(object),
                GSON.fromJson(ticketType, TicketType.class)
        );
    }

    @JavascriptInterface
    public void onObjectDeselected(String object, String ticketType) {
        config.onObjectDeselected.accept(
                toSeatsObject(object),
                GSON.fromJson(ticketType, TicketType.class)
        );
    }

    @JavascriptInterface
    public void onObjectClicked(String object) {
        config.onObjectClicked.accept(toSeatsObject(object));
    }

    @JavascriptInterface
    public void onBestAvailableSelected(String objects, String nextToEachOther) {
        config.onBestAvailableSelected.accept(
                toSeatsObjects(objects),
                GSON.fromJson(nextToEachOther, Boolean.class)
        );
    }

    @JavascriptInterface
    public void onBestAvailableSelectionFailed() {
        config.onBestAvailableSelectionFailed.run();
    }

    @JavascriptInterface
    public void onHoldSucceeded(String objects, String ticketTypes) {
        config.onHoldSucceeded.accept(
                GSON.fromJson(objects, OBJECT_LIST_TYPE),
                GSON.fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onHoldFailed(String objects, String ticketTypes) {
        config.onHoldFailed.accept(
                GSON.fromJson(objects, OBJECT_LIST_TYPE),
                GSON.fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onReleaseHoldSucceeded(String objects, String ticketTypes) {
        config.onReleaseHoldSucceeded.accept(
                GSON.fromJson(objects, OBJECT_LIST_TYPE),
                GSON.fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onReleaseHoldFailed(String objects, String ticketTypes) {
        config.onReleaseHoldFailed.accept(
                GSON.fromJson(objects, OBJECT_LIST_TYPE),
                GSON.fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
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
        config.onSelectionInvalid.accept(GSON.fromJson(violations, listType));
    }

    @JavascriptInterface
    public void onSelectedObjectBooked(String object) {
        config.onSelectedObjectBooked.accept(toSeatsObject(object));
    }

    @JavascriptInterface
    public void onChartRendered() {
        seatsioWebView.post(() -> config.onChartRendered.accept((SeatingChartView) seatsioWebView));
    }

    @JavascriptInterface
    public void onChartRenderingFailed() {
        config.onChartRenderingFailed.accept((SeatingChartView) seatsioWebView);
    }

    @JavascriptInterface
    public String tooltipInfo(String object) {
        return config.tooltipInfo.apply(toSeatsObject(object));
    }

    @JavascriptInterface
    public String formatPrice(float price) {
        return config.priceFormatter.apply(price);
    }

    @JavascriptInterface
    public void asyncCallSuccess(String result, String requestId) {
        seatsioWebView.onAsyncCallSuccess(result, requestId);
    }

    @JavascriptInterface
    public void asyncCallError(String requestId) {
        seatsioWebView.onAsyncCallError(requestId);
    }

    private SeatsioObject toSeatsObject(String object) {
        return GSON.fromJson(object, SeatsioObject.class).init((SeatingChartView) seatsioWebView);
    }

    private List<SeatsioObject> toSeatsObjects(String objects) {
        Type listType = new TypeToken<List<SeatsioObject>>() {
        }.getType();

        List<SeatsioObject> seatsioObjects = GSON.fromJson(objects, listType);
        seatsioObjects.forEach(object -> object.init((SeatingChartView) seatsioWebView));

        return seatsioObjects;
    }
}
