package io.seats.eventManager;

import com.google.gson.annotations.Expose;

public class ManageCategoriesModeConfig extends EventManagerConfig {

    @Expose
    public Boolean unavailableObjectsSelectable;

    public ManageCategoriesModeConfig setUnavailableObjectsSelectable(Boolean unavailableObjectsSelectable) {
        this.unavailableObjectsSelectable = unavailableObjectsSelectable;
        return this;
    }
}
