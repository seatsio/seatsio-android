package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class TicketTypeWithQuantity {

    @Expose
    public String ticketType;

    @Expose
    public int quantity;

    public TicketTypeWithQuantity(String ticketType, int quantity) {
        this.ticketType = ticketType;
        this.quantity = quantity;
    }
}
