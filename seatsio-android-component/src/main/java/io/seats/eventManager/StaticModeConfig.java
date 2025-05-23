package io.seats.eventManager;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.function.Function;

import io.seats.seatingChart.SeatsioObject;

public class StaticModeConfig extends EventManagerConfig implements HasTooltipContents {

    @Expose
    public ObjectPopover objectPopover;

    public Function<SeatsioObject, String> tooltipContents;

    public String objectIconJavaScriptFunction;

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
        this.tooltipContents = tooltipContents;
        return this;
    }

    @Override
    public Function<SeatsioObject, String> getTooltipContents() {
        return tooltipContents;
    }

    public StaticModeConfig setObjectIconJavaScriptFunction(String objectIconJavaScriptFunction) {
        this.objectIconJavaScriptFunction = objectIconJavaScriptFunction;
        return this;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (tooltipContents != null) {
            callbacks.add("tooltipContents: (object) => Native.tooltipContents(JSON.stringify(object))");
        }

        if (objectIconJavaScriptFunction != null) {
            callbacks.add("objectIcon: " + objectIconJavaScriptFunction);
        }

        return callbacks;
    }
}
