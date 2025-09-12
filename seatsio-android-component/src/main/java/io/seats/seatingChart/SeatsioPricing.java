package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.function.Function;

public class SeatsioPricing {

    @Expose
    public final List<Pricing> prices;

    @Expose
    public Boolean allFeesIncluded;

    @Expose
    public Boolean showSectionPricingOverlay;

    public Function<Float, String> priceFormatter;

    public SeatsioPricing(List<Pricing> prices) {
        this(prices, null, null, null);
    }

    public SeatsioPricing(List<Pricing> prices, Boolean allFeesIncluded, Boolean showSectionPricingOverlay, Function<Float, String> priceFormatter) {
        this.prices = prices;
        this.allFeesIncluded = allFeesIncluded;
        this.showSectionPricingOverlay = showSectionPricingOverlay;
        this.priceFormatter = priceFormatter;
    }

    public SeatsioPricing setAllFeesIncluded(Boolean allFeesIncluded) {
        this.allFeesIncluded = allFeesIncluded;
        return this;
    }

    public SeatsioPricing setPriceFormatter(Function<Float, String> priceFormatter) {
        this.priceFormatter = priceFormatter;
        return this;
    }

    public SeatsioPricing setShowSectionPricingOverlay(Boolean showSectionPricingOverlay) {
        this.showSectionPricingOverlay = showSectionPricingOverlay;
        return this;
    }
}
