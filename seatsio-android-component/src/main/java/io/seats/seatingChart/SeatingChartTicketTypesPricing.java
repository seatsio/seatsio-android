package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.Arrays;
import java.util.List;

public class SeatingChartTicketTypesPricing extends SeatingChartPricing {

    @Expose
    public final List<SeatingChartTicketTypePricing> ticketTypes;

    public SeatingChartTicketTypesPricing(String category, SeatingChartTicketTypePricing... ticketTypes) {
        super(category);
        this.ticketTypes = Arrays.asList(ticketTypes);
    }
}
