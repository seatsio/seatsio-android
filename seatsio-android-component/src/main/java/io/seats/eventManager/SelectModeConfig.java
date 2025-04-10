package io.seats.eventManager;

import static java.util.Arrays.asList;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import io.seats.seatingChart.CategoryWithQuantity;
import io.seats.seatingChart.CategoryWithTicketTypesAndQuantity;
import io.seats.seatingChart.SeatsioObject;
import io.seats.seatingChart.SelectedObject;
import io.seats.seatingChart.TicketTypeWithQuantity;
import io.seats.utils.Function3;

public class SelectModeConfig extends EventManagerConfig implements HasIsObjectSelectable {

    @Expose
    public Object maxSelectedObjects;

    @Expose
    public Integer numberOfPlacesToSelect;

    @Expose
    public List<SelectedObject> selectedObjects;

    @Expose
    public String selectionBy;

    public List<CategoryWithTicketTypes> ticketTypes;

    @Expose
    public ObjectPopover objectPopover;

    @Expose
    public Boolean unavailableObjectsSelectable;

    @Expose
    public List<String> selectableObjects;

    public Object isObjectSelectable;

    public Object objectIcon;

    public SelectModeConfig() {
        setMode(EventManagerMode.SELECT);
    }

    @Override
    public SelectModeConfig setMode(EventManagerMode mode) {
        if (mode != EventManagerMode.SELECT) {
            throw new IllegalArgumentException("Mode must be 'select'");
        }
        return this;
    }

    public SelectModeConfig setMaxSelectedObjects(int maxSelectedObjects) {
        this.maxSelectedObjects = maxSelectedObjects;
        return this;
    }

    public SelectModeConfig setMaxSelectedObjects(CategoryWithQuantity... maxSelectedObjects) {
        this.maxSelectedObjects = asList(maxSelectedObjects);
        return this;
    }

    public SelectModeConfig setMaxSelectedObjects(TicketTypeWithQuantity... maxSelectedObjects) {
        this.maxSelectedObjects = asList(maxSelectedObjects);
        return this;
    }

    public SelectModeConfig setMaxSelectedObjects(CategoryWithTicketTypesAndQuantity... maxSelectedObjects) {
        this.maxSelectedObjects = asList(maxSelectedObjects);
        return this;
    }

    public SelectModeConfig setNumberOfPlacesToSelect(Integer numberOfPlacesToSelect) {
        this.numberOfPlacesToSelect = numberOfPlacesToSelect;
        return this;
    }

    public SelectModeConfig setSelectedObjects(List<SelectedObject> selectedObjects) {
        this.selectedObjects = selectedObjects;
        return this;
    }

    public SelectModeConfig setSelectionBy(String selectionBy) {
        this.selectionBy = selectionBy;
        return this;
    }

    public SelectModeConfig setTicketTypes(CategoryWithTicketTypes... ticketTypes) {
        this.ticketTypes = asList(ticketTypes);
        return this;
    }

    public SelectModeConfig setObjectPopover(ObjectPopover objectPopover) {
        this.objectPopover = objectPopover;
        return this;
    }

    public SelectModeConfig setUnavailableObjectsSelectable(Boolean unavailableObjectsSelectable) {
        this.unavailableObjectsSelectable = unavailableObjectsSelectable;
        return this;
    }

    public SelectModeConfig setSelectableObjects(List<String> selectableObjects) {
        this.selectableObjects = selectableObjects;
        return this;
    }

    public SelectModeConfig setIsObjectSelectable(Function<SeatsioObject, Boolean> isObjectSelectable) {
        this.isObjectSelectable = isObjectSelectable;
        return this;
    }

    public SelectModeConfig setIsObjectSelectable(String isObjectSelectable) {
        this.isObjectSelectable = isObjectSelectable;
        return this;
    }

    @Override
    public Function<SeatsioObject, Boolean> getIsObjectSelectable() {
        return isObjectSelectable != null && isObjectSelectable instanceof Function ? (Function<SeatsioObject, Boolean>)isObjectSelectable : null;
    }

    public SelectModeConfig setObjectIcon(Function3<SeatsioObject, String, Map<String, ?>, String> objectIcon) {
        this.objectIcon = objectIcon;
        return this;
    }

    public SelectModeConfig setObjectIcon(String objectIcon) {
        this.objectIcon = objectIcon;
        return this;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (isObjectSelectable != null) {
            if (isObjectSelectable instanceof String) {
                callbacks.add("isObjectSelectable: " + isObjectSelectable);
            } else {
                callbacks.add("isObjectSelectable: (object) => Native.isObjectSelectable(JSON.stringify(object))");
            }
        }

        if (objectIcon != null) {
            if (objectIcon instanceof String) {
                callbacks.add("objectIcon: " + objectIcon);
            } else {
                callbacks.add("objectIcon: (object, defaultIcon, extraConfig) => Native.objectIcon(JSON.stringify(object), defaultIcon, extraConfig)");
            }
        }

        return callbacks;
    }
}
