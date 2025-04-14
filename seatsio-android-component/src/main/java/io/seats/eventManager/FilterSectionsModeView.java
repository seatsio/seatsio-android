package io.seats.eventManager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import io.seats.Region;

public class FilterSectionsModeView extends EventManagerView {

    public FilterSectionsModeView(Region region, FilterSectionsModeConfig config, Context context) {
        super(region, config, context);
    }

    public FilterSectionsModeView(Region region, FilterSectionsModeConfig config, Context context, @Nullable AttributeSet attrs) {
        super(region, config, context, attrs);
    }

    public FilterSectionsModeView(Region region, FilterSectionsModeConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(region, config, context, attrs, defStyleAttr);
    }

    public FilterSectionsModeView(Region region, FilterSectionsModeConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(region, config, context, attrs, defStyleAttr, defStyleRes);
    }

    public void setFilteredSection(String label) {
        caller.call("chart.setHighlightedObjects('" + label + "')");
    }

    public void clearFilteredSection() {
        caller.call("chart.clearFilteredSection()");
    }
}
