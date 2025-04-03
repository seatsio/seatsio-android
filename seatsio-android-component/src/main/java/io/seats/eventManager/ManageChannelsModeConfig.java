package io.seats.eventManager;

import com.google.gson.annotations.Expose;

public class ManageChannelsModeConfig extends EventManagerConfig {

    @Expose
    public Boolean manageChannelsList;

    @Expose
    public Boolean unavailableObjectsSelectable;

    public ManageChannelsModeConfig setManageChannelsList(Boolean manageChannelsList) {
        this.manageChannelsList = manageChannelsList;
        return this;
    }

    public ManageChannelsModeConfig setUnavailableObjectsSelectable(Boolean unavailableObjectsSelectable) {
        this.unavailableObjectsSelectable = unavailableObjectsSelectable;
        return this;
    }
}
