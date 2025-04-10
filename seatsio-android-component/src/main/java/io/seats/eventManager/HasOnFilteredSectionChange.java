package io.seats.eventManager;

import java.util.List;
import java.util.function.Consumer;

import io.seats.seatingChart.Section;

public interface HasOnFilteredSectionChange {

    Consumer<Section[]> getOnFilteredSectionChange();
}
