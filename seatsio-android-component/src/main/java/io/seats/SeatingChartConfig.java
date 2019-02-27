package io.seats;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class SeatingChartConfig {

    @Expose
    public String publicKey;
    @Expose
    public Collection<String> events;
    @Expose
    private List<SeatingChartPricing> pricing;
    @Expose
    public Boolean objectWithoutPricingSelectable;
    @Expose
    public Boolean objectWithoutCategorySelectable;
    @Expose
    public List<String> selectedObjects;

    public Consumer<SeatsioObject> onObjectSelected;
    public Runnable onChartRendered;
    public Function<Float, String> priceFormatter;

    public SeatingChartConfig withPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public SeatingChartConfig withEvent(String event) {
        HashSet<String> events = new HashSet<>();
        events.add(event);
        this.events = events;
        return this;
    }

    public SeatingChartConfig withEvents(Collection<String> events) {
        this.events = events;
        return this;
    }

    public SeatingChartConfig withPricing(SeatingChartPricing... pricing) {
        this.pricing = Arrays.asList(pricing);
        return this;
    }

    public SeatingChartConfig withOnObjectSelected(Consumer<SeatsioObject> onObjectSelected) {
        this.onObjectSelected = onObjectSelected;
        return this;
    }

    public SeatingChartConfig withOnChartRendered(Runnable onChartRendered) {
        this.onChartRendered = onChartRendered;
        return this;
    }

    public SeatingChartConfig withPriceFormatter(Function<Float, String> priceFormatter) {
        this.priceFormatter = priceFormatter;
        return this;
    }

    public SeatingChartConfig withObjectWithoutPricingSelectable(boolean objectWithoutPricingSelectable) {
        this.objectWithoutPricingSelectable = objectWithoutPricingSelectable;
        return this;
    }

    public SeatingChartConfig withObjectWithoutCategorySelectable(boolean objectWithoutCategorySelectable) {
        this.objectWithoutCategorySelectable = objectWithoutCategorySelectable;
        return this;
    }

    public SeatingChartConfig withSelectedObjects(String... selectedObjects) {
        this.selectedObjects = Arrays.asList(selectedObjects);
        return this;
    }

    public String toJson() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String configAsJson = gson.toJson(this);
        String configAsJsonWithoutLastChar = configAsJson.substring(0, configAsJson.length() - 1);

        configAsJsonWithoutLastChar += ", onObjectSelected: object => Native.onObjectSelected(JSON.stringify(object))";
        configAsJsonWithoutLastChar += ", onChartRendered: object => Native.onChartRendered()";
        configAsJsonWithoutLastChar += ", priceFormatter: price => Native.formatPrice(price)";

        configAsJson = configAsJsonWithoutLastChar + "}";
        return configAsJson;
    }

}
