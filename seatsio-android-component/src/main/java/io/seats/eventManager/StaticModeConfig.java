package io.seats.eventManager;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import io.seats.seatingChart.SeatsioObject;
import io.seats.utils.Function3;

public class StaticModeConfig extends EventManagerConfig implements HasObjectIcon, HasTooltipContents {

    @Expose
    public ObjectPopover objectPopover;

    public Object tooltipContents;

    public Object objectIcon;

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

    public StaticModeConfig setTooltipContents(String tooltipContents) {
        this.tooltipContents = tooltipContents;
        return this;
    }

    @Override
    public Function<SeatsioObject, String> getTooltipContents() {
        return tooltipContents != null && tooltipContents instanceof Function ? (Function<SeatsioObject, String>)tooltipContents : null;
    }

    public StaticModeConfig setObjectIcon(Function3<SeatsioObject, String, Map<String, ?>, String> objectIcon) {
        this.objectIcon = objectIcon;
        return this;
    }

    public StaticModeConfig setObjectIcon(String objectIcon) {
        this.objectIcon = objectIcon;
        return this;
    }

    @Override
    public Function3<SeatsioObject, String, Map<String, ?>, String> getObjectIcon() {
        return objectIcon != null && objectIcon instanceof Function3 ? (Function3<SeatsioObject, String, Map<String, ?>, String>)objectIcon : null;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (tooltipContents != null) {
            if (tooltipContents instanceof String) {
                callbacks.add("tooltipContents: " + tooltipContents);
            } else {
                callbacks.add("tooltipContents: (object) => Native.tooltipContents(JSON.stringify(object))");
            }
        }

        if (objectIcon != null) {
            if (objectIcon instanceof String) {
                callbacks.add("objectIcon: " + objectIcon);
            } else {
                callbacks.add("objectIcon: (object, defaultIcon, extraConfig) => Native.objectIcon(JSON.stringify(object), defaultIcon, extraConfig)");
            }
        }

        return callbacks;
    }
}
