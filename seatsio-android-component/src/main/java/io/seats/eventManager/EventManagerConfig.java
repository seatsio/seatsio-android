package io.seats.eventManager;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import java.util.Collection;
import java.util.HashSet;

public class EventManagerConfig {

    @Expose
    public String secretKey;

    @Expose
    public String event;

    @Expose
    public Collection<String> events;

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
        HashSet<String> events = new HashSet<>();
        events.add(event);
        this.events = events;
        return this;
    }

    public EventManagerConfig setEvents(Collection<String> events) {
        this.events = events;
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
