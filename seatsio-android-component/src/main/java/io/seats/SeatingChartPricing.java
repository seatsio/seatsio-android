package io.seats;

import com.google.gson.annotations.Expose;

abstract public class SeatingChartPricing {

    @Expose
    public String category;

    SeatingChartPricing(String category) {
        this.category = category;
    }
}
