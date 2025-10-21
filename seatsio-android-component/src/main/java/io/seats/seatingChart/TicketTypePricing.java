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
    @Expose
    public Boolean primary;
    @Expose
    public Float originalPrice;
    @Expose
    public Float fee;

    public TicketTypePricing(float price, String ticketType) {
        this(price, ticketType, null);
    }

    public TicketTypePricing(float price, String ticketType, String label) {
        this(price, ticketType, label, null);
    }

    public TicketTypePricing(float price, String ticketType, String label, String description) {
        this(price, ticketType, label, description, null);
    }

    public TicketTypePricing(float price, String ticketType, String label, String description, Boolean primary) {
        this(price, ticketType, label, description, primary, null);
    }

    public TicketTypePricing(float price, String ticketType, String label, String description, Boolean primary, Float originalPrice) {
        this.price = price;
        this.ticketType = ticketType;
        this.label = label;
        this.description = description;
        this.primary = primary;
        this.originalPrice = originalPrice;
    }

    public TicketTypePricing setDescription(String description) {
        this.description = description;
        return this;
    }

    public TicketTypePricing setLabel(String label) {
        this.label = label;
        return this;
    }

    public TicketTypePricing setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public TicketTypePricing setPrimary(Boolean primary) {
        this.primary = primary;
        return this;
    }

    public TicketTypePricing setFee(float fee) {
        this.fee = fee;
        return this;
    }
}
