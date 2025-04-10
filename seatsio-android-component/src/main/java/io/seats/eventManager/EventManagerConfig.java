package io.seats.eventManager;

import com.google.gson.annotations.Expose;

import java.util.List;

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

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();


        return callbacks;
    }
}
