package io.seats;

import android.webkit.JavascriptInterface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import io.seats.seatingChart.Pricing;
import io.seats.seatingChart.PromptsApiParams;
import io.seats.seatingChart.SeatingChartConfig;
import io.seats.seatingChart.SeatsioObject;
import io.seats.seatingChart.TicketType;

public class SeatsioJavascriptInterface<U extends SeatsioWebView<?>, T extends CommonConfig<?, U>> {

    protected U seatsioWebView;
    protected T config;

    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Pricing.class, new Pricing.PricingDeserializer())
            .registerTypeAdapter(Instant.class, instantDeserializer())
            .create();

    protected static final Type OBJECT_LIST_TYPE = new TypeToken<List<SeatsioObject>>() {
    }.getType();

    private static JsonDeserializer<Instant> instantDeserializer() {
        return (JsonElement json, Type typeOfT, JsonDeserializationContext ctx) -> Instant.parse(json.getAsJsonPrimitive().getAsString());
    }

    public SeatsioJavascriptInterface(T config) {
        this.config = config;
    }

    public void init(U seatsioWebView) {
        this.seatsioWebView = seatsioWebView;
    }

    @JavascriptInterface
    public String tooltipInfo(String object) {
        return config.tooltipInfo.apply(toSeatsObject(object));
    }

    public String popoverInfo(String object) {
        return config.popoverInfo.apply(toSeatsObject(object));
    }

    @JavascriptInterface
    public void onChartRendered() {
        seatsioWebView.post(() -> config.onChartRendered.accept(seatsioWebView));
    }

    @JavascriptInterface
    public void onChartRenderingFailed() {
        config.onChartRenderingFailed.accept(seatsioWebView);
    }

    @JavascriptInterface
    public void onChartRerenderingStarted() {
        config.onChartRerenderingStarted.accept(seatsioWebView);
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
    public void onPlacesPrompt(String params) {
        if (config instanceof SeatingChartConfig) {
            ((SeatingChartConfig)config).onPlacesPrompt.accept(
                    GSON.fromJson(params, PromptsApiParams.OnPlacesPromptParams.class),
                    (Integer places) -> seatsioWebView.callInternalCallback("onPlacesPrompt", places)
            );
        }
    }

    @JavascriptInterface
    public void onPlacesWithTicketTypesPrompt(String params) {
        if (config instanceof SeatingChartConfig) {
            ((SeatingChartConfig)config).onPlacesWithTicketTypesPrompt.accept(
                    GSON.fromJson(params, PromptsApiParams.OnPlacesWithTicketTypesPromptParams.class),
                    (Map<String, Integer> types) -> seatsioWebView.callInternalCallback("onPlacesWithTicketTypesPrompt", types)
            );
        }
    }

    @JavascriptInterface
    public void onTicketTypePrompt(String params) {
        if (config instanceof SeatingChartConfig) {
            ((SeatingChartConfig)config).onTicketTypePrompt.accept(
                    GSON.fromJson(params, PromptsApiParams.OnTicketTypePromptParams.class),
                    (String type) -> seatsioWebView.callInternalCallback("onTicketTypePrompt", type)
            );
        }
    }

    @JavascriptInterface
    public String objectColor(String object, String defaultColor, String extraConfig) {
        return config.objectColor.apply(toSeatsObject(object), defaultColor, GSON.fromJson(extraConfig, Map.class));
    }

    @JavascriptInterface
    public void asyncCallSuccess(String result, String requestId) {
        seatsioWebView.onAsyncCallSuccess(result, requestId);
    }

    @JavascriptInterface
    public void asyncCallError(String requestId) {
        seatsioWebView.onAsyncCallError(requestId);
    }

    protected SeatsioObject toSeatsObject(String object) {
        return GSON.fromJson(object, SeatsioObject.class);
    }

    protected List<SeatsioObject> toSeatsObjects(String objects) {
        Type listType = new TypeToken<List<SeatsioObject>>() {
        }.getType();

        return GSON.fromJson(objects, listType);
    }
}
