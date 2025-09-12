package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ObjectPrice extends Price {

    @Expose
    public Float price;

    @Expose
    public Float originalPrice;

    @Expose
    public List<String> objects;

    @Expose
    public List<TicketTypePricing> ticketTypes;

    public ObjectPrice(List<String> objects, Float price) {
        this(objects, price, null);
    }

    public ObjectPrice(List<String> objects, Float price, Float originalPrice) {
        this.objects = objects;
        this.price = price;
        this.originalPrice = originalPrice;
    }

    public ObjectPrice(List<String> objects, List<TicketTypePricing> ticketTypes) {
        this.objects = objects;
        this.ticketTypes = ticketTypes;
    }
}
