package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ChannelPricing {

    @Expose
    public String channel;

    @Expose
    public Float price;

    @Expose
    public Float originalPrice;

    @Expose
    public List<TicketTypePricing> ticketTypes;

    public ChannelPricing(String channel, Float price) {
        this(channel, price, null);
    }

    public ChannelPricing(String channel, Float price, Float originalPrice) {
        this.channel = channel;
        this.price = price;
        this.originalPrice = originalPrice;
    }

    public ChannelPricing(String channel, List<TicketTypePricing> ticketTypes) {
        this.channel = channel;
        this.ticketTypes = ticketTypes;
    }
}
