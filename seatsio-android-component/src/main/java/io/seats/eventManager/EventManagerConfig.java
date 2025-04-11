package io.seats.eventManager;

import com.google.gson.annotations.Expose;

import io.seats.CommonConfig;

public class EventManagerConfig extends CommonConfig<EventManagerConfig, EventManagerView> {

    @Expose
    public String secretKey;

    @Expose
    public EventManagerMode mode;

    public EventManagerConfig setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public EventManagerConfig setMode(EventManagerMode mode) {
        this.mode = mode;
        return this;
    }
}
