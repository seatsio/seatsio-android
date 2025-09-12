package io.seats.seatingChart;

import android.webkit.JavascriptInterface;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import io.seats.SeatsioJavascriptInterface;

public class SeatingChartJavascriptInterface extends SeatsioJavascriptInterface<SeatingChartView, SeatingChartConfig> {

    private static final Type TICKET_TYPE_LIST_TYPE = new TypeToken<List<TicketType>>() {
    }.getType();

    private static final Type CATEGORY_LIST_TYPE = new TypeToken<List<Category>>() {
    }.getType();

    public SeatingChartJavascriptInterface(SeatingChartConfig config) {
        super(config);
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
    public void onHoldCallsInProgress() {
        config.onHoldCallsInProgress.run();
    }

    @JavascriptInterface
    public void onHoldCallsComplete() {
        config.onHoldCallsComplete.run();
    }

    @JavascriptInterface
    public void onSelectedObjectBooked(String object) {
        config.onSelectedObjectBooked.accept(toSeatsObject(object));
    }

    @JavascriptInterface
    public void onObjectStatusChanged(String object) {
        config.onObjectStatusChanged.accept(toSeatsObject(object));
    }

    @JavascriptInterface
    public void onSessionInitialized(String holdToken) {
        config.onSessionInitialized.accept(GSON.fromJson(holdToken, HoldToken.class));
    }

    @JavascriptInterface
    public void onHoldTokenExpired() {
        config.onHoldTokenExpired.run();
    }

    @JavascriptInterface
    public void onFloorChanged(String floor) {
        config.onFloorChanged.accept(GSON.fromJson(floor, Floor.class));
    }

    @JavascriptInterface
    public void onFilteredCategoriesChanged(String categories) {
        config.onFilteredCategoriesChanged.accept(GSON.fromJson(categories, CATEGORY_LIST_TYPE));
    }

    @JavascriptInterface
    public String formatPrice(float price) {
        return config.pricing.priceFormatter.apply(price);
    }

    /** @noinspection unchecked*/
    @JavascriptInterface
    public String sectionColor(String section, String defaultColor, String extraConfig) {
        return config.sectionColor.apply(GSON.fromJson(section, Section.class), defaultColor, GSON.fromJson(extraConfig, Map.class));
    }

    /** @noinspection unchecked*/
    @JavascriptInterface
    public Boolean canGASelectionBeIncreased(String object, boolean defaultValue, String extraConfig, String ticketType) {
        return config.canGASelectionBeIncreased.apply(toSeatsObject(object), defaultValue, GSON.fromJson(extraConfig, Map.class), GSON.fromJson(ticketType, TicketTypePricing.class));
    }

    @JavascriptInterface
    public void onPlacesPrompt(String params) {
        config.onPlacesPrompt.accept(
                GSON.fromJson(params, PromptsApiParams.OnPlacesPromptParams.class),
                (Integer places) -> seatsioWebView.callInternalCallback("onPlacesPrompt", places)
        );
    }

    @JavascriptInterface
    public void onPlacesWithTicketTypesPrompt(String params) {
        config.onPlacesWithTicketTypesPrompt.accept(
                GSON.fromJson(params, PromptsApiParams.OnPlacesWithTicketTypesPromptParams.class),
                (Map<String, Integer> types) -> seatsioWebView.callInternalCallback("onPlacesWithTicketTypesPrompt", types)
        );
    }

    @JavascriptInterface
    public void onTicketTypePrompt(String params) {
        config.onTicketTypePrompt.accept(
                GSON.fromJson(params, PromptsApiParams.OnTicketTypePromptParams.class),
                (String type) -> seatsioWebView.callInternalCallback("onTicketTypePrompt", type)
        );
    }
}
