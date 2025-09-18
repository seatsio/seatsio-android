package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class SimplePrice extends Price {

    @Expose
    public Float price;

    @Expose
    public Float originalPrice;

    public SimplePrice(float price) {
        this(price, null);
    }

    public SimplePrice(float price, Float originalPrice) {
        this.price = price;
        this.originalPrice = originalPrice;
    }
}
