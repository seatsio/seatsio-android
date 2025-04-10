package io.seats.seatingChart;

import android.webkit.JavascriptInterface;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import io.seats.SeatsioJavascriptInterface;
import io.seats.utils.Function3;
import io.seats.utils.Function4;

/** @noinspection unchecked*/
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
        ((BiConsumer<List<SeatsioObject>, Boolean>)config.onBestAvailableSelected).accept(
                toSeatsObjects(objects),
                GSON.fromJson(nextToEachOther, Boolean.class)
        );
    }

    @JavascriptInterface
    public void onBestAvailableSelectionFailed() {
        ((Runnable)config.onBestAvailableSelectionFailed).run();
    }

    @JavascriptInterface
    public void onHoldSucceeded(String objects, String ticketTypes) {
        ((BiConsumer<List<SeatsioObject>, List<TicketType>>)config.onHoldSucceeded).accept(
                GSON.fromJson(objects, OBJECT_LIST_TYPE),
                GSON.fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onHoldFailed(String objects, String ticketTypes) {
        ((BiConsumer<List<SeatsioObject>, List<TicketType>>)config.onHoldFailed).accept(
                GSON.fromJson(objects, OBJECT_LIST_TYPE),
                GSON.fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onReleaseHoldSucceeded(String objects, String ticketTypes) {
        ((BiConsumer<List<SeatsioObject>, List<TicketType>>)config.onReleaseHoldSucceeded).accept(
                GSON.fromJson(objects, OBJECT_LIST_TYPE),
                GSON.fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onReleaseHoldFailed(String objects, String ticketTypes) {
        ((BiConsumer<List<SeatsioObject>, List<TicketType>>)config.onReleaseHoldFailed).accept(
                GSON.fromJson(objects, OBJECT_LIST_TYPE),
                GSON.fromJson(ticketTypes, TICKET_TYPE_LIST_TYPE)
        );
    }

    @JavascriptInterface
    public void onSelectionValid() {
        ((Runnable)config.onSelectionValid).run();
    }

    @JavascriptInterface
    public void onSelectionInvalid(String violations) {
        Type listType = new TypeToken<List<SelectionValidatorType>>() {
        }.getType();
        ((Consumer<List<SelectionValidatorType>>)config.onSelectionInvalid).accept(GSON.fromJson(violations, listType));
    }

    @JavascriptInterface
    public void onHoldCallsInProgress() {
        ((Runnable)config.onHoldCallsInProgress).run();
    }

    @JavascriptInterface
    public void onHoldCallsComplete() {
        ((Runnable)config.onHoldCallsComplete).run();
    }

    @JavascriptInterface
    public void onSelectedObjectBooked(String object) {
        ((Consumer<SeatsioObject>)config.onSelectedObjectBooked).accept(toSeatsObject(object));
    }

    @JavascriptInterface
    public void onObjectStatusChanged(String object) {
        ((Consumer<SeatsioObject>)config.onObjectStatusChanged).accept(toSeatsObject(object));
    }

    @JavascriptInterface
    public void onSessionInitialized(String holdToken) {
        ((Consumer<HoldToken>)config.onSessionInitialized).accept(GSON.fromJson(holdToken, HoldToken.class));
    }

    @JavascriptInterface
    public void onHoldTokenExpired() {
        ((Runnable)config.onHoldTokenExpired).run();
    }

    @JavascriptInterface
    public void onFloorChanged(String floor) {
        ((Consumer<Floor>)config.onFloorChanged).accept(GSON.fromJson(floor, Floor.class));
    }

    @JavascriptInterface
    public void onFilteredCategoriesChanged(String categories) {
        ((Consumer<List<Category>>)config.onFilteredCategoriesChanged).accept(GSON.fromJson(categories, CATEGORY_LIST_TYPE));
    }

    @JavascriptInterface
    public String formatPrice(float price) {
        return ((Function<Float, String>)config.priceFormatter).apply(price);
    }

    @JavascriptInterface
    public String sectionColor(String section, String defaultColor, String extraConfig) {
        return ((Function3<Section, String, Map<String, ?>, String>)config.sectionColor).apply(GSON.fromJson(section, Section.class), defaultColor, GSON.fromJson(extraConfig, Map.class));
    }

    @JavascriptInterface
    public String objectLabel(String object, String defaultLabel, String extraConfig) {
        return ((Function3<SeatsioObject, String, Map<String, ?>, String>)config.objectLabel).apply(toSeatsObject(object), defaultLabel, GSON.fromJson(extraConfig, Map.class));
    }

    @JavascriptInterface
    public String objectIcon(String object, String defaultIcon, String extraConfig) {
        return ((Function3<SeatsioObject, String, Map<String, ?>, String>)config.objectIcon).apply(toSeatsObject(object), defaultIcon, GSON.fromJson(extraConfig, Map.class));
    }

    @JavascriptInterface
    public boolean isObjectVisible(String object, String extraConfig) {
        return ((BiFunction<SeatsioObject, Map<String, ?>, Boolean>)config.isObjectVisible).apply(toSeatsObject(object), GSON.fromJson(extraConfig, Map.class));
    }

    @JavascriptInterface
    public Boolean canGASelectionBeIncreased(String object, boolean defaultValue, String extraConfig, String ticketType) {
        return ((Function4<SeatsioObject, Boolean, Map<String, ?>, TicketTypePricing, Boolean>)config.canGASelectionBeIncreased).apply(toSeatsObject(object), defaultValue, GSON.fromJson(extraConfig, Map.class), GSON.fromJson(ticketType, TicketTypePricing.class));
    }

    @JavascriptInterface
    public void onPlacesPrompt(String params) {
        ((BiConsumer<PromptsApiParams.OnPlacesPromptParams, Consumer<Integer>>)config.onPlacesPrompt).accept(
                GSON.fromJson(params, PromptsApiParams.OnPlacesPromptParams.class),
                (Integer places) -> seatsioWebView.callInternalCallback("onPlacesPrompt", places)
        );
    }

    @JavascriptInterface
    public void onPlacesWithTicketTypesPrompt(String params) {
        ((BiConsumer<PromptsApiParams.OnPlacesWithTicketTypesPromptParams, Consumer<Map<String, Integer>>>)config.onPlacesWithTicketTypesPrompt).accept(
                GSON.fromJson(params, PromptsApiParams.OnPlacesWithTicketTypesPromptParams.class),
                (Map<String, Integer> types) -> seatsioWebView.callInternalCallback("onPlacesWithTicketTypesPrompt", types)
        );
    }

    @JavascriptInterface
    public void onTicketTypePrompt(String params) {
        ((BiConsumer<PromptsApiParams.OnTicketTypePromptParams, Consumer<String>>)config.onTicketTypePrompt).accept(
                GSON.fromJson(params, PromptsApiParams.OnTicketTypePromptParams.class),
                (String type) -> seatsioWebView.callInternalCallback("onTicketTypePrompt", type)
        );
    }
}
