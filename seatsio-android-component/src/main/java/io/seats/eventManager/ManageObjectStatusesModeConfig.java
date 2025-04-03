package io.seats.eventManager;

import com.google.gson.annotations.Expose;

public class ManageObjectStatusesModeConfig extends EventManagerConfig {

    @Expose
    public String session;

    public ManageObjectStatusesModeConfig setSession(String session) {
        this.session = session;
        return this;
    }
}
