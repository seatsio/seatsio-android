package io.seats.eventManager;

import java.util.List;
import java.util.function.Consumer;

import io.seats.seatingChart.Section;

public class FilterSectionsModeConfig extends EventManagerConfig implements HasOnFilteredSectionChange {

    public Consumer<Section[]> onFilteredSectionChange;

    public FilterSectionsModeConfig() {
        setMode(EventManagerMode.FILTER_SECTIONS);
    }

    @Override
    public FilterSectionsModeConfig setMode(EventManagerMode mode) {
        if (mode != EventManagerMode.FILTER_SECTIONS) {
            throw new IllegalArgumentException("Mode must be 'filterSections'");
        }
        return this;
    }

    public FilterSectionsModeConfig setOnFilteredSectionChange(Consumer<Section[]> onFilteredSectionChange) {
        this.onFilteredSectionChange = onFilteredSectionChange;
        return this;
    }

    @Override
    public Consumer<Section[]> getOnFilteredSectionChange() {
        return onFilteredSectionChange;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (onFilteredSectionChange != null) {
            callbacks.add("onFilteredSectionChange: (sections) => Native.onFilteredSectionChange(JSON.stringify(sections))");
        }

        return callbacks;
    }
}
