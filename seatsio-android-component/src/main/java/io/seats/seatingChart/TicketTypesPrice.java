package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.Arrays;
import java.util.List;

public class TicketTypesPrice extends Price {

    @Expose
    public final List<TicketTypePricing> ticketTypes;

    public TicketTypesPrice(TicketTypePricing... ticketTypes) {
        this.ticketTypes = Arrays.asList(ticketTypes);
    }
}
