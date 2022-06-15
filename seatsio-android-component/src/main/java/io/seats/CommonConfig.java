package io.seats;

import static java.lang.String.join;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import io.seats.seatingChart.ColorScheme;
import io.seats.seatingChart.Colors;
import io.seats.seatingChart.PricingForCategory;
import io.seats.seatingChart.SeatsioObject;
import io.seats.seatingChart.Style;
import io.seats.seatingChart.StylePreset;
import io.seats.seatingChart.TicketType;

public class CommonConfig<T extends CommonConfig<?, ?>, U extends SeatsioWebView<?>> {

    @Expose
    public Collection<String> events;

    @Expose
    public String language;

    @Expose
    public Map<String, String> messages;

    @Expose
    public boolean showFullScreenButton = false;

    @Expose
    public Map<String, ?> extraConfig;

    @Expose
    public ColorScheme colorScheme;

    @Expose
    public Colors colors;

    @Expose
    public StylePreset stylePreset;

    @Expose
    public Style style;

    public String objectColor;
    public Function<SeatsioObject, String> tooltipInfo;
    public BiConsumer<SeatsioObject, TicketType> onObjectSelected;
    public BiConsumer<SeatsioObject, TicketType> onObjectDeselected;
    public Consumer<SeatsioObject> onObjectClicked;
    public Consumer<U> onChartRendered;
    public Consumer<U> onChartRenderingFailed;

    public T setEvent(String event) {
        HashSet<String> events = new HashSet<>();
        events.add(event);
        this.events = events;
        return (T) this;
    }

    public T setEvents(Collection<String> events) {
        this.events = events;
        return (T) this;
    }

    public T setLanguage(String language) {
        this.language = language;
        return (T) this;
    }

    public T setMessages(Map<String, String> messages) {
        this.messages = messages;
        return (T) this;
    }

    public T setTooltipInfo(Function<SeatsioObject, String> tooltipInfo) {
        this.tooltipInfo = tooltipInfo;
        return (T) this;
    }

    public T setExtraConfig(Map<String, ?> extraConfig) {
        this.extraConfig = extraConfig;
        return (T) this;
    }

    public T setObjectColor(String objectColor) {
        this.objectColor = objectColor;
        return (T) this;
    }

    public T setColorScheme(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
        return (T) this;
    }

    public T setColors(Colors colors) {
        this.colors = colors;
        return (T) this;
    }

    public T setStylePreset(StylePreset stylePreset) {
        this.stylePreset = stylePreset;
        return (T) this;
    }

    public T setStyle(Style style) {
        this.style = style;
        return (T) this;
    }

    public T setOnChartRendered(Consumer<U> onChartRendered) {
        this.onChartRendered = onChartRendered;
        return (T) this;
    }

    public T setOnChartRenderingFailed(Consumer<U> onChartRenderingFailed) {
        this.onChartRenderingFailed = onChartRenderingFailed;
        return (T) this;
    }

    public T setOnObjectSelected(BiConsumer<SeatsioObject, TicketType> onObjectSelected) {
        this.onObjectSelected = onObjectSelected;
        return (T) this;
    }

    public T setOnObjectDeselected(BiConsumer<SeatsioObject, TicketType> onObjectDeselected) {
        this.onObjectDeselected = onObjectDeselected;
        return (T) this;
    }

    public T setOnObjectClicked(Consumer<SeatsioObject> onObjectClicked) {
        this.onObjectClicked = onObjectClicked;
        return (T) this;
    }

    protected List<String> callbacks() {
        List<String> callbacks = new ArrayList<>();

        if (tooltipInfo != null) {
            callbacks.add("tooltipInfo: object => Native.tooltipInfo(JSON.stringify(object))");
        }

        if (objectColor != null) {
            callbacks.add("objectColor: " + objectColor);
        }

        if (onObjectSelected != null) {
            callbacks.add("onObjectSelected: (object, ticketType) => Native.onObjectSelected(JSON.stringify(object), ticketType ? JSON.stringify(ticketType) : null)");
        }

        if (onObjectDeselected != null) {
            callbacks.add("onObjectDeselected: (object, ticketType) => Native.onObjectDeselected(JSON.stringify(object), ticketType ? JSON.stringify(ticketType) : null)");
        }

        if (onObjectClicked != null) {
            callbacks.add("onObjectClicked: object => Native.onObjectClicked(JSON.stringify(object))");
        }

        if (onChartRendered != null) {
            callbacks.add("onChartRendered: object => Native.onChartRendered()");
        }

        if (onChartRenderingFailed != null) {
            callbacks.add("onChartRenderingFailed: object => Native.onChartRenderingFailed()");
        }

        return callbacks;
    }

    public String toJson() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(PricingForCategory.class, new PricingForCategory.PricingForCategorySerializer())
                .create();

        String configAsJson = gson.toJson(this);
        String configAsJsonWithoutLastChar = configAsJson.substring(0, configAsJson.length() - 1);
        configAsJsonWithoutLastChar += "," + join(", ", callbacks());
        configAsJson = configAsJsonWithoutLastChar + "}";
        return configAsJson;
    }
}
