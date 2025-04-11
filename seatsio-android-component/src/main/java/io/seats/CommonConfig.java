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
import io.seats.utils.Either;

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

    public String objectColorJavascriptFunction;

    public Either<String, Function<SeatsioObject, String>> tooltipInfo;
    public Either<String, Function<SeatsioObject, String>> popoverInfo;
    public Either<String, BiConsumer<SeatsioObject, TicketType>> onObjectSelected;
    public Either<String, BiConsumer<SeatsioObject, TicketType>> onObjectDeselected;
    public Either<String, Consumer<SeatsioObject>> onObjectClicked;
    public Either<String, Consumer<U>> onChartRendered;
    public Either<String, Consumer<U>> onChartRenderingFailed;
    public Either<String, Consumer<U>> onChartRerenderingStarted;

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
        this.tooltipInfo = Either.right(tooltipInfo);
        return (T) this;
    }

    public T setTooltipInfo(String tooltipInfo) {
        this.tooltipInfo = Either.left(tooltipInfo);
        return (T) this;
    }

    public T popoverInfo(Function<SeatsioObject, String> popoverInfo) {
        this.popoverInfo = Either.right(popoverInfo);
        return (T) this;
    }

    public T popoverInfo(String popoverInfo) {
        this.popoverInfo = Either.left(popoverInfo);
        return (T) this;
    }

    public T setExtraConfig(Map<String, ?> extraConfig) {
        this.extraConfig = extraConfig;
        return (T) this;
    }

    public T setObjectColorJavascriptFunction(String objectColorJavascriptFunction) {
        this.objectColorJavascriptFunction = objectColorJavascriptFunction;
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
        this.onChartRendered = Either.right(onChartRendered);
        return (T) this;
    }

    public T setOnChartRendered(String onChartRendered) {
        this.onChartRendered = Either.left(onChartRendered);
        return (T) this;
    }

    public T setOnChartRenderingFailed(Consumer<U> onChartRenderingFailed) {
        this.onChartRenderingFailed = Either.right(onChartRenderingFailed);
        return (T) this;
    }

    public T setOnChartRenderingFailed(String onChartRenderingFailed) {
        this.onChartRenderingFailed = Either.left(onChartRenderingFailed);
        return (T) this;
    }

    public T setOnChartRerenderingStarted(Consumer<U> onChartRerenderingStarted) {
        this.onChartRerenderingStarted = Either.right(onChartRerenderingStarted);
        return (T) this;
    }

    public T setOnChartRerenderingStarted(String onChartRerenderingStarted) {
        this.onChartRerenderingStarted = Either.left(onChartRerenderingStarted);
        return (T) this;
    }

    public T setOnObjectSelected(BiConsumer<SeatsioObject, TicketType> onObjectSelected) {
        this.onObjectSelected = Either.right(onObjectSelected);
        return (T) this;
    }

    public T setOnObjectSelected(String onObjectSelected) {
        this.onObjectSelected = Either.left(onObjectSelected);
        return (T) this;
    }

    public T setOnObjectDeselected(BiConsumer<SeatsioObject, TicketType> onObjectDeselected) {
        this.onObjectDeselected = Either.right(onObjectDeselected);
        return (T) this;
    }

    public T setOnObjectDeselected(String onObjectDeselected) {
        this.onObjectDeselected = Either.left(onObjectDeselected);
        return (T) this;
    }

    public T setOnObjectClicked(Consumer<SeatsioObject> onObjectClicked) {
        this.onObjectClicked = Either.right(onObjectClicked);
        return (T) this;
    }

    public T setOnObjectClicked(String onObjectClicked) {
        this.onObjectClicked = Either.left(onObjectClicked);
        return (T) this;
    }

    protected List<String> callbacks() {
        List<String> callbacks = new ArrayList<>();

        if (objectColorJavascriptFunction != null) {
            callbacks.add("objectColor: " + objectColorJavascriptFunction);
        }

        if (tooltipInfo != null) {
            tooltipInfo.forEach(
                    value -> callbacks.add("tooltipInfo: " + value),
                    value -> callbacks.add("tooltipInfo: (object) => Native.tooltipInfo(JSON.stringify(object))")
            );
        }

        if (popoverInfo != null) {
            popoverInfo.forEach(
                    value -> callbacks.add("popoverInfo: " + value),
                    value -> callbacks.add("popoverInfo: (object) => Native.popoverInfo(JSON.stringify(object))")
            );
        }

        if (onObjectSelected != null) {
            onObjectSelected.forEach(
                    value -> callbacks.add("onObjectSelected: " + value),
                    value -> callbacks.add("onObjectSelected: (object, ticketType) => Native.onObjectSelected(JSON.stringify(object), ticketType ? JSON.stringify(ticketType) : null)")
            );
        }

        if (onObjectDeselected != null) {
            onObjectDeselected.forEach(
                    value -> callbacks.add("onObjectDeselected: " + value),
                    value -> callbacks.add("onObjectDeselected: (object, ticketType) => Native.onObjectDeselected(JSON.stringify(object), ticketType ? JSON.stringify(ticketType) : null)")
            );
        }

        if (onObjectClicked != null) {
            onObjectClicked.forEach(
                    value -> callbacks.add("onObjectClicked: " + value),
                    value -> callbacks.add("onObjectClicked: (object) => Native.onObjectClicked(JSON.stringify(object))")
            );
        }

        if (onChartRendered != null) {
            onChartRendered.forEach(
                    value -> callbacks.add("onChartRendered: " + value),
                    value -> callbacks.add("onChartRendered: (object) => Native.onChartRendered()")
            );
        }

        if (onChartRenderingFailed != null) {
            onChartRenderingFailed.forEach(
                    value -> callbacks.add("onChartRenderingFailed: " + value),
                    value -> callbacks.add("onChartRenderingFailed: (object) => Native.onChartRenderingFailed()")
            );
        }

        if (onChartRerenderingStarted != null) {
            onChartRerenderingStarted.forEach(
                    value -> callbacks.add("onChartRerenderingStarted: " + value),
                    value -> callbacks.add("onChartRerenderingStarted: (object) => Native.onChartRerenderingStarted()")
            );
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
