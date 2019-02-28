package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class SelectedObject {

    @Expose
    public String label;

    @Expose
    public Integer amount;

    @Expose
    public String ticketType;

    public SelectedObject(String label) {
        this.label = label;
    }

    public SelectedObject(String label, int amount) {
        this.label = label;
        this.amount = amount;
    }

    public SelectedObject(String label, String ticketType) {
        this.label = label;
        this.ticketType = ticketType;
    }

    public SelectedObject(String label, String ticketType, int amount) {
        this.label = label;
        this.ticketType = ticketType;
        this.amount = amount;
    }
}
