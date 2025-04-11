package io.seats.eventManager;

import java.util.List;
import java.util.function.Consumer;

import io.seats.seatingChart.Section;
import io.seats.utils.Either;

public class FilterSectionsModeConfig extends EventManagerConfig implements HasOnFilteredSectionChange {

    public Either<String, Consumer<Section[]>> onFilteredSectionChange;

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
        this.onFilteredSectionChange = Either.right(onFilteredSectionChange);
        return this;
    }

    public FilterSectionsModeConfig setOnFilteredSectionChange(String onFilteredSectionChange) {
        this.onFilteredSectionChange = Either.left(onFilteredSectionChange);
        return this;
    }

    @Override
    public Consumer<Section[]> getOnFilteredSectionChange() {
        if (onFilteredSectionChange == null) {
            return null;
        }
        return onFilteredSectionChange.getOrNull();
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (onFilteredSectionChange != null) {
            onFilteredSectionChange.forEach(
                    value -> callbacks.add("onFilteredSectionChange: " + value),
                    value -> callbacks.add("onFilteredSectionChange: (sections) => Native.onFilteredSectionChange(JSON.stringify(sections))")
            );
        }

        return callbacks;
    }
}
