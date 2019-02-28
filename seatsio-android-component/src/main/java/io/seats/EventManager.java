package io.seats;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class EventManager extends SeatsioWebView {

    private final EventManagerConfig config;

    public EventManager(EventManagerConfig config, Context context) {
        super(config.toJson(), context);
        this.config = config;
    }

    public EventManager(EventManagerConfig config, Context context, @Nullable AttributeSet attrs) {
        super(config.toJson(), context, attrs);
        this.config = config;
    }

    public EventManager(EventManagerConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(config.toJson(), context, attrs, defStyleAttr);
        this.config = config;
    }

    public EventManager(EventManagerConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(config.toJson(), context, attrs, defStyleAttr, defStyleRes);
        this.config = config;
    }

    @Override
    Object seatingChartInterface() {
        return new EventManagerInterface();
    }

}
