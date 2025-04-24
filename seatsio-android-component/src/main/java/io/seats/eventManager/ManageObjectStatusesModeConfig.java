package io.seats.eventManager;

import com.google.gson.annotations.Expose;

public class ManageObjectStatusesModeConfig extends EventManagerConfig {

    @Expose
    public String session;

    public ManageObjectStatusesModeConfig() {
        setMode(EventManagerMode.MANAGE_OBJECT_STATUSES);
    }

    @Override
    public ManageObjectStatusesModeConfig setMode(EventManagerMode mode) {
        if (mode != EventManagerMode.MANAGE_OBJECT_STATUSES) {
            throw new IllegalArgumentException("Mode must be 'manageObjectStatuses'");
        }
        return this;
    }

    public ManageObjectStatusesModeConfig setSession(String session) {
        this.session = session;
        return this;
    }
}
