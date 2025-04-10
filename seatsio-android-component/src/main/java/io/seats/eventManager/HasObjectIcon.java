package io.seats.eventManager;

import java.util.Map;

import io.seats.seatingChart.SeatsioObject;
import io.seats.utils.Function3;

public interface HasObjectIcon {

    Function3<SeatsioObject, String, Map<String, ?>, String> getObjectIcon();
}
