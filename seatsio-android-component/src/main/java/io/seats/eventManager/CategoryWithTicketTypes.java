package io.seats.eventManager;

import static java.util.Arrays.asList;

import com.google.gson.annotations.Expose;

import java.util.List;

public class CategoryWithTicketTypes {

    @Expose
    public Integer category;

    @Expose
    public List<TicketType> ticketTypes;

    public CategoryWithTicketTypes(Integer category, TicketType... ticketTypes) {
        this.category = category;
        this.ticketTypes = asList(ticketTypes);
    }
}
