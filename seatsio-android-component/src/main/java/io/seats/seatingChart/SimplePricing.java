package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class SimplePricing extends Pricing {

    @Expose
    public float price;

    public SimplePricing(String category, float price) {
        super(category);
        this.price = price;
    }
}
