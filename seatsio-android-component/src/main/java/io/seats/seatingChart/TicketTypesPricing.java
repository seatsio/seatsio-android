package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.Arrays;
import java.util.List;

public class TicketTypesPricing extends Pricing {

    @Expose
    public final List<TicketTypePricing> ticketTypes;

    public TicketTypesPricing(String category, TicketTypePricing... ticketTypes) {
        super(category);
        this.ticketTypes = Arrays.asList(ticketTypes);
    }
}
