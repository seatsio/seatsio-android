package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class TicketTypePricing {

    @Expose
    public float price;
    @Expose
    public String ticketType;
    @Expose
    public String label;
    @Expose
    public String description;

    public TicketTypePricing(float price, String ticketType) {
        this.price = price;
        this.ticketType = ticketType;
    }

    public TicketTypePricing(float price, String ticketType, String label) {
        this.price = price;
        this.ticketType = ticketType;
        this.label = label;
    }

    public TicketTypePricing(float price, String ticketType, String label, String description) {
        this.price = price;
        this.ticketType = ticketType;
        this.label = label;
        this.description = description;
    }
}
