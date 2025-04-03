package io.seats.seatingChart;

import static java.util.Arrays.asList;

import com.google.gson.annotations.Expose;

import java.util.List;

public class CategoryWithTicketTypesAndQuantity {

    @Expose
    public String category;

    @Expose
    public List<TicketTypeWithQuantity> ticketTypes;

    public CategoryWithTicketTypesAndQuantity(String category, TicketTypeWithQuantity... ticketTypes) {
        this.category = category;
        this.ticketTypes = asList(ticketTypes);
    }
}
