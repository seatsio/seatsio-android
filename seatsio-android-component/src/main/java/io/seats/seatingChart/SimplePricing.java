package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class SimplePricing extends Pricing {

    @Expose
    public float price;

    public SimplePricing(float price) {
        this.price = price;
    }
}
