package io.seats.eventManager;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

public class EventManagerConfig {

    @Expose
    public String secretKey;

    @Expose
    public String event;

    @Expose
    public EventManagerMode mode;

    @Expose
    public String language;

    public String toJson() {
        return new Gson().toJson(this);
    }

    public EventManagerConfig setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public EventManagerConfig setEvent(String event) {
        this.event = event;
        return this;
    }

    public EventManagerConfig setMode(EventManagerMode mode) {
        this.mode = mode;
        return this;
    }

    public EventManagerConfig setLanguage(String language) {
        this.language = language;
        return this;
    }


}
