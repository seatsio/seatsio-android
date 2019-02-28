package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class TicketListing {

    @Expose
    public String section;

    @Expose
    public int quantity;

    @Expose
    public float price;

    public TicketListing(String section, int quantity, float price) {
        this.section = section;
        this.quantity = quantity;
        this.price = price;
    }
}
