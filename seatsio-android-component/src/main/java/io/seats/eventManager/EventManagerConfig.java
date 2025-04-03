package io.seats.eventManager;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import io.seats.CommonConfig;
import io.seats.seatingChart.SeatsioObject;
import io.seats.utils.Function3;

public class EventManagerConfig extends CommonConfig<EventManagerConfig, EventManagerView> {

    @Expose
    public String secretKey;

    @Expose
    public EventManagerMode mode;

    public Function<SeatsioObject, String> tooltipContents;

    public Function3<SeatsioObject, String, Map<String, ?>, String> objectIcon;

    public EventManagerConfig setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public EventManagerConfig setMode(EventManagerMode mode) {
        this.mode = mode;
        return this;
    }

    public EventManagerConfig setTooltipContents(Function<SeatsioObject, String> tooltipContents) {
        this.tooltipContents = tooltipContents;
        return this;
    }

    public EventManagerConfig setObjectIcon(Function3<SeatsioObject, String, Map<String, ?>, String> objectIcon) {
        this.objectIcon = objectIcon;
        return this;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (tooltipContents != null) {
            callbacks.add("tooltipContents: (object) => Native.tooltipContents(JSON.stringify(object))");
        }

        if (objectIcon != null) {
            callbacks.add("objectIcon: (object, defaultIcon, extraConfig) => Native.objectIcon(JSON.stringify(object), defaultIcon, extraConfig)");
        }

        return callbacks;
    }
}
