package io.seats.eventManager;

import com.google.gson.Gson;

import java.util.List;

public interface WithHighlightableObjects extends WithCaller {

    default void setHighlightedObjects(List<String> objectLabels) {
        getCaller().call("chart.setHighlightedObjects(" + new Gson().toJson(objectLabels) + ")");
    }

    default void clearHighlightedObjects() {
        getCaller().call("chart.clearHighlightedObjects()");
    }
}
