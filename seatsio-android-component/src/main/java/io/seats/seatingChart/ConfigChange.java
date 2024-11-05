package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class ConfigChange {

    @Expose
    public String objectColor;

    @Expose
    public String objectLabel;

    @Expose
    public Integer numberOfPlacesToSelect;

    @Expose
    public Object maxSelectedObjects;

    @Expose
    public Map<String, ?> extraConfig;

    @Expose
    public List<String> unavailableCategories;

    @Expose
    public List<String> availableCategories;

    @Expose
    public List<String> filteredCategories;

    @Expose
    public List<PricingForCategory> pricing;

    @Expose
    public List<String> channels;

    public ConfigChange setObjectColor(String objectColor) {
        this.objectColor = objectColor;
        return this;
    }

    public ConfigChange setObjectLabel(String objectLabel) {
        this.objectLabel = objectLabel;
        return this;
    }

    public ConfigChange setNumberOfPlacesToSelect(int numberOfPlacesToSelect) {
        this.numberOfPlacesToSelect = numberOfPlacesToSelect;
        return this;
    }

    public ConfigChange setMaxSelectedObjects(int maxSelectedObjects) {
        this.maxSelectedObjects = maxSelectedObjects;
        return this;
    }

    public ConfigChange setMaxSelectedObjects(CategoryWithQuantity... maxSelectedObjects) {
        this.maxSelectedObjects = asList(maxSelectedObjects);
        return this;
    }

    public ConfigChange setExtraConfig(Map<String, ?> extraConfig) {
        this.extraConfig = extraConfig;
        return this;
    }

    public ConfigChange setUnavailableCategories(List<String> unavailableCategories) {
        this.unavailableCategories = unavailableCategories;
        return this;
    }

    public ConfigChange setAvailableCategories(List<String> availableCategories) {
        this.availableCategories = availableCategories;
        return this;
    }

    public ConfigChange setFilteredCategories(List<String> filteredCategories) {
        this.filteredCategories = filteredCategories;
        return this;
    }

    public ConfigChange setPricing(List<PricingForCategory> pricing) {
        this.pricing = pricing;
        return this;
    }

    public ConfigChange setChannels(List<String> channels) {
        this.channels = channels;
        return this;
    }
}
