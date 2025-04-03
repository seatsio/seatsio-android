package io.seats.eventManager;

import com.google.gson.annotations.Expose;

import java.util.Map;
import java.util.function.Function;

import io.seats.seatingChart.SeatsioObject;
import io.seats.utils.Function3;

public class StaticModeConfig extends EventManagerConfig {

    @Expose
    public ObjectPopover objectPopover;

    public Function<SeatsioObject, String> tooltipContents;

    public Function3<SeatsioObject, String, Map<String, ?>, String> objectIcon;
}
