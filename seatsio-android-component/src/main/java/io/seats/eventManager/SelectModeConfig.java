package io.seats.eventManager;

import static java.util.Arrays.asList;

import com.google.gson.annotations.Expose;

import java.util.List;

import io.seats.seatingChart.CategoryWithQuantity;
import io.seats.seatingChart.CategoryWithTicketTypesAndQuantity;
import io.seats.seatingChart.SelectedObject;
import io.seats.seatingChart.TicketTypeWithQuantity;

public class SelectModeConfig extends EventManagerConfig {

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

    public String isObjectSelectableJavaScriptFunction;

    public String objectIconJavaScriptFunction;

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

    public SelectModeConfig setIsObjectSelectableJavaScriptFunction(String isObjectSelectableJavaScriptFunction) {
        this.isObjectSelectableJavaScriptFunction = isObjectSelectableJavaScriptFunction;
        return this;
    }

    public SelectModeConfig setObjectIconJavaScriptFunction(String objectIconJavaScriptFunction) {
        this.objectIconJavaScriptFunction = objectIconJavaScriptFunction;
        return this;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (isObjectSelectableJavaScriptFunction != null) {
            callbacks.add("isObjectSelectable: " + isObjectSelectableJavaScriptFunction);
        }

        if (objectIconJavaScriptFunction != null) {
            callbacks.add("objectIcon: " + objectIconJavaScriptFunction);
        }

        return callbacks;
    }
}
