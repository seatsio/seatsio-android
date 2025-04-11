package io.seats.eventManager;

import java.util.function.Function;

import io.seats.seatingChart.SeatsioObject;

public interface HasTooltipContents {

    Function<SeatsioObject, String> getTooltipContents();
}
