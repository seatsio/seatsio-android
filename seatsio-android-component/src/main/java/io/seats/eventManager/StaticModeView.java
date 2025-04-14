package io.seats.eventManager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import io.seats.Region;

public class StaticModeView extends EventManagerView implements WithHighlightableObjects {

    public StaticModeView(Region region, StaticModeConfig config, Context context) {
        super(region, config, context);
    }

    public StaticModeView(Region region, StaticModeConfig config, Context context, @Nullable AttributeSet attrs) {
        super(region, config, context, attrs);
    }

    public StaticModeView(Region region, StaticModeConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(region, config, context, attrs, defStyleAttr);
    }

    public StaticModeView(Region region, StaticModeConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(region, config, context, attrs, defStyleAttr, defStyleRes);
    }
}
