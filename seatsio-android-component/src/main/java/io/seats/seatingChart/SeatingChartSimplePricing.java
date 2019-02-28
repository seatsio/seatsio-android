package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class SeatingChartSimplePricing extends SeatingChartPricing {

    @Expose
    public float price;

    public SeatingChartSimplePricing(String category, float price) {
        super(category);
        this.price = price;
    }
}
