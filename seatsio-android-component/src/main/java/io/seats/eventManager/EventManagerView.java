package io.seats.eventManager;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import io.seats.Region;
import io.seats.SeatsioWebView;

public class EventManagerView extends SeatsioWebView {

    private final EventManagerConfig config;

    public EventManagerView(Region region, EventManagerConfig config, Context context) {
        super(region, config.toJson(), new EventManagerJavascriptInterface(), context);
        this.config = config;
    }

    public EventManagerView(Region region, EventManagerConfig config, Context context, @Nullable AttributeSet attrs) {
        super(region, config.toJson(), new EventManagerJavascriptInterface(), context, attrs);
        this.config = config;
    }

    public EventManagerView(Region region, EventManagerConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(region, config.toJson(), new EventManagerJavascriptInterface(), context, attrs, defStyleAttr);
        this.config = config;
    }

    public EventManagerView(Region region, EventManagerConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(region, config.toJson(), new EventManagerJavascriptInterface(), context, attrs, defStyleAttr, defStyleRes);
        this.config = config;
    }

}
