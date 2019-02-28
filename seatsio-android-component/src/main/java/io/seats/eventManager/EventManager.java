package io.seats.eventManager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import io.seats.SeatsioWebView;

public class EventManager extends SeatsioWebView {

    private final EventManagerConfig config;

    public EventManager(EventManagerConfig config, Context context) {
        super(config.toJson(), new EventManagerInterface(), context);
        this.config = config;
    }

    public EventManager(EventManagerConfig config, Context context, @Nullable AttributeSet attrs) {
        super(config.toJson(), new EventManagerInterface(), context, attrs);
        this.config = config;
    }

    public EventManager(EventManagerConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(config.toJson(), new EventManagerInterface(), context, attrs, defStyleAttr);
        this.config = config;
    }

    public EventManager(EventManagerConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(config.toJson(), new EventManagerInterface(), context, attrs, defStyleAttr, defStyleRes);
        this.config = config;
    }

}
