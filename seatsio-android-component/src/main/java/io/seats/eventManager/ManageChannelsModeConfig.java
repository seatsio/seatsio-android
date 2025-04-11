package io.seats.eventManager;

import com.google.gson.annotations.Expose;

public class ManageChannelsModeConfig extends EventManagerConfig {

    @Expose
    public Boolean manageChannelsList;

    @Expose
    public Boolean unavailableObjectsSelectable;

    public ManageChannelsModeConfig() {
        setMode(EventManagerMode.MANAGE_CHANNELS);
    }

    @Override
    public ManageChannelsModeConfig setMode(EventManagerMode mode) {
        if (mode != EventManagerMode.MANAGE_CHANNELS) {
            throw new IllegalArgumentException("Mode must be 'manageChannels'");
        }
        return this;
    }

    public ManageChannelsModeConfig setManageChannelsList(Boolean manageChannelsList) {
        this.manageChannelsList = manageChannelsList;
        return this;
    }

    public ManageChannelsModeConfig setUnavailableObjectsSelectable(Boolean unavailableObjectsSelectable) {
        this.unavailableObjectsSelectable = unavailableObjectsSelectable;
        return this;
    }
}
