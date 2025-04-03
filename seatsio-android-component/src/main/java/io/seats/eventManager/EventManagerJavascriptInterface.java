package io.seats.eventManager;

import android.webkit.JavascriptInterface;

import java.util.Map;

import io.seats.SeatsioJavascriptInterface;

public class EventManagerJavascriptInterface extends SeatsioJavascriptInterface<EventManagerView, EventManagerConfig> {

    public EventManagerJavascriptInterface(EventManagerConfig config) {
        super(config);
    }

    @JavascriptInterface
    public String tooltipContents(String object) {
        return config.tooltipContents.apply(toSeatsObject(object));
    }

    @JavascriptInterface
    public boolean isObjectSelectable(String object) {
        return ((SelectModeConfig)config).isObjectSelectable.apply(toSeatsObject(object));
    }

    @JavascriptInterface
    public String objectIcon(String object, String defaultIcon, String extraData) {
        return config.objectIcon.apply(toSeatsObject(object), defaultIcon, GSON.fromJson(extraData, Map.class));
    }
}
