package io.seats.eventManager;

import com.google.gson.annotations.Expose;

public class TicketType {

    @Expose
    public String ticketType;

    @Expose
    public String label;

    @Expose
    public String description;

    public TicketType setTicketType(String ticketType) {
        this.ticketType = ticketType;
        return this;
    }

    public TicketType setLabel(String label) {
        this.label = label;
        return this;
    }

    public TicketType setDescription(String description) {
        this.description = description;
        return this;
    }
}
