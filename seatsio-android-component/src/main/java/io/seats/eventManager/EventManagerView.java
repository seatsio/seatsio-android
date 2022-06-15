package io.seats.eventManager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import io.seats.Region;
import io.seats.SeatsioWebView;

public class EventManagerView extends SeatsioWebView<EventManagerView> {

    private final EventManagerConfig config;

    @Override
    protected String toolName() {
        return "EventManager";
    }

    public EventManagerView(Region region, EventManagerConfig config, Context context) {
        super(region, config.toJson(), new EventManagerJavascriptInterface(config), context);
        this.config = config;
    }

    public EventManagerView(Region region, EventManagerConfig config, Context context, @Nullable AttributeSet attrs) {
        super(region, config.toJson(), new EventManagerJavascriptInterface(config), context, attrs);
        this.config = config;
    }

    public EventManagerView(Region region, EventManagerConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(region, config.toJson(), new EventManagerJavascriptInterface(config), context, attrs, defStyleAttr);
        this.config = config;
    }

    public EventManagerView(Region region, EventManagerConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(region, config.toJson(), new EventManagerJavascriptInterface(config), context, attrs, defStyleAttr, defStyleRes);
        this.config = config;
    }
}
