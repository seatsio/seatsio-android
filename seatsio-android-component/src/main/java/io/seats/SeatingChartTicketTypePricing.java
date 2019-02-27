package io.seats;

import com.google.gson.annotations.Expose;

public class SeatingChartTicketTypePricing {

    @Expose
    public float price;
    @Expose
    public String ticketType;
    @Expose
    public String label;

    public SeatingChartTicketTypePricing(float price, String ticketType) {
        this.price = price;
        this.ticketType = ticketType;
    }

    public SeatingChartTicketTypePricing(float price, String ticketType, String label) {
        this.price = price;
        this.ticketType = ticketType;
        this.label = label;
    }
}
