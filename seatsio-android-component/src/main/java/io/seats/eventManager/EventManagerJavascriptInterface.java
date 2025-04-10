package io.seats.eventManager;

import android.webkit.JavascriptInterface;

import java.util.Map;

import io.seats.SeatsioJavascriptInterface;
import io.seats.seatingChart.Section;

public class EventManagerJavascriptInterface extends SeatsioJavascriptInterface<EventManagerView, EventManagerConfig> {

    public EventManagerJavascriptInterface(EventManagerConfig config) {
        super(config);
    }

    @JavascriptInterface
    public String tooltipContents(String object) {
        return ((HasTooltipContents)config).getTooltipContents().apply(toSeatsObject(object));
    }

    @JavascriptInterface
    public boolean isObjectSelectable(String object) {
        return ((HasIsObjectSelectable)config).getIsObjectSelectable().apply(toSeatsObject(object));
    }

    @JavascriptInterface
    public String objectIcon(String object, String defaultIcon, String extraConfig) {
        return ((HasObjectIcon)config).getObjectIcon().apply(toSeatsObject(object), defaultIcon, GSON.fromJson(extraConfig, Map.class));
    }

    @JavascriptInterface
    public void onFilteredSectionChange(String sections) {
        ((HasOnFilteredSectionChange)config).getOnFilteredSectionChange().accept(GSON.fromJson(sections, Section[].class));
    }
}
