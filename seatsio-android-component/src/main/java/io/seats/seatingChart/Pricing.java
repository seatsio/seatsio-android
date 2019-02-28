package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

abstract public class Pricing {

    @Expose
    public String category;

    Pricing(String category) {
        this.category = category;
    }
}
