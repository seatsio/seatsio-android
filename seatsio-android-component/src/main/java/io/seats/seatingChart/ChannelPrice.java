package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ChannelPrice extends Price {

    @Expose
    public List<ChannelPricing> channels;

    @Expose
    public Float price;

    @Expose
    public Float originalPrice;

    public ChannelPrice(List<ChannelPricing> channels, Float price) {
        this(channels, price, null);
    }

    public ChannelPrice(List<ChannelPricing> channels, Float price, Float originalPrice) {
        this.channels = channels;
        this.price = price;
        this.originalPrice = originalPrice;
    }
}
