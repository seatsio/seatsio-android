package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class CategoryFilter {

    @Expose
    public Boolean enabled;

    @Expose
    public Boolean multiSelect;

    @Expose
    public Boolean zoomOnSelect;

    public CategoryFilter setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public CategoryFilter setMultiSelect(Boolean multiSelect) {
        this.multiSelect = multiSelect;
        return this;
    }

    public CategoryFilter setZoomOnSelect(Boolean zoomOnSelect) {
        this.zoomOnSelect = zoomOnSelect;
        return this;
    }
}
