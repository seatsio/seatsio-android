package io.seats.eventManager;

import java.util.function.Function;

import io.seats.seatingChart.SeatsioObject;

public interface HasIsObjectSelectable {

    Function<SeatsioObject, Boolean> getIsObjectSelectable();
}
