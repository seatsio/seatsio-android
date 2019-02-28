package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.Map;

import static java.util.Arrays.asList;

public class ConfigChange {

    @Expose
    public String objectColor;

    @Expose
    public String objectLabel;

    @Expose
    public Object maxSelectedObjects;

    @Expose
    public Map<String, ?> extraConfig;

    public ConfigChange setObjectColor(String objectColor) {
        this.objectColor = objectColor;
        return this;
    }

    public ConfigChange setObjectLabel(String objectLabel) {
        this.objectLabel = objectLabel;
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
}
