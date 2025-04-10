package io.seats.eventManager;

import com.google.gson.annotations.Expose;

public class ManageCategoriesModeConfig extends EventManagerConfig {

    @Expose
    public Boolean unavailableObjectsSelectable;

    public ManageCategoriesModeConfig() {
        setMode(EventManagerMode.MANAGE_CATEGORIES);
    }

    @Override
    public EventManagerConfig setMode(EventManagerMode mode) {
        if (mode != EventManagerMode.MANAGE_CATEGORIES) {
            throw new IllegalArgumentException("Mode must be 'manageCategories'");
        }
        return this;
    }

    public ManageCategoriesModeConfig setUnavailableObjectsSelectable(Boolean unavailableObjectsSelectable) {
        this.unavailableObjectsSelectable = unavailableObjectsSelectable;
        return this;
    }
}
