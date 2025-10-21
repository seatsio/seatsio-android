package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class SimplePrice extends Price {

    @Expose
    public Float price;

    @Expose
    public Float originalPrice;

    @Expose
    public Float fee;

    public SimplePrice(float price) {
        this(price, null);
    }

    public SimplePrice(float price, Float originalPrice) {
        this.price = price;
        this.originalPrice = originalPrice;
    }

    public SimplePrice setFee(float fee) {
        this.fee = fee;
        return this;
    }
}
