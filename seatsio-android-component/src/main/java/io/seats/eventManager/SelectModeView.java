package io.seats.eventManager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import io.seats.Region;

public class SelectModeView extends EventManagerView implements WithHighlightableObjects {

    public SelectModeView(Region region, SelectModeConfig config, Context context) {
        super(region, config, context);
    }

    public SelectModeView(Region region, SelectModeConfig config, Context context, @Nullable AttributeSet attrs) {
        super(region, config, context, attrs);
    }

    public SelectModeView(Region region, SelectModeConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(region, config, context, attrs, defStyleAttr);
    }

    public SelectModeView(Region region, SelectModeConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(region, config, context, attrs, defStyleAttr, defStyleRes);
    }
}
