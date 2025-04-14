package io.seats.eventManager;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.function.Function;

import io.seats.seatingChart.SeatsioObject;
import io.seats.utils.Either;

public class StaticModeConfig extends EventManagerConfig implements HasTooltipContents {

    @Expose
    public ObjectPopover objectPopover;

    public Either<String, Function<SeatsioObject, String>> tooltipContents;

    public String objectIconJavascriptFunction;

    public StaticModeConfig() {
        setMode(EventManagerMode.STATIC);
    }

    @Override
    public StaticModeConfig setMode(EventManagerMode mode) {
        if (mode != EventManagerMode.STATIC) {
            throw new IllegalArgumentException("Mode must be 'static'");
        }
        return this;
    }

    public void setObjectPopover(ObjectPopover objectPopover) {
        this.objectPopover = objectPopover;
    }

    public StaticModeConfig setTooltipContents(Function<SeatsioObject, String> tooltipContents) {
        this.tooltipContents = Either.right(tooltipContents);
        return this;
    }

    public StaticModeConfig setTooltipContents(String tooltipContents) {
        this.tooltipContents = Either.left(tooltipContents);
        return this;
    }

    @Override
    public Function<SeatsioObject, String> getTooltipContents() {
        if (tooltipContents == null) {
            return null;
        }
        return tooltipContents.getOrNull();
    }

    public StaticModeConfig setObjectIconJavascriptFunction(String objectIconJavascriptFunction) {
        this.objectIconJavascriptFunction = objectIconJavascriptFunction;
        return this;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (tooltipContents != null) {
            tooltipContents.forEach(
                    value -> callbacks.add("tooltipContents: " + value),
                    value -> callbacks.add("tooltipContents: (object) => Native.tooltipContents(JSON.stringify(object))")
            );
        }

        if (objectIconJavascriptFunction != null) {
            callbacks.add("objectIcon: " + objectIconJavascriptFunction);
        }

        return callbacks;
    }
}
