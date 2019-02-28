package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class CategoryWithQuantity {

    @Expose
    public String category;

    @Expose
    public int quantity;

    public CategoryWithQuantity(String category, int quantity) {
        this.category = category;
        this.quantity = quantity;
    }
}
