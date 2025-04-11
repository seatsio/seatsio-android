package io.seats.eventManager;

import android.webkit.JavascriptInterface;

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
    public void onFilteredSectionChange(String sections) {
        ((HasOnFilteredSectionChange)config).getOnFilteredSectionChange().accept(GSON.fromJson(sections, Section[].class));
    }
}
