package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class Category {

    @Expose
    public String key;

    @Expose
    public String color;

    @Expose
    public String label;

    @Expose
    public Boolean accessible;

    @Expose
    public SeatShape seatShape;

    public Category setKey(String key) {
        this.key = key;
        return this;
    }

    public Category setColor(String color) {
        this.color = color;
        return this;
    }

    public Category setLabel(String label) {
        this.label = label;
        return this;
    }

    public Category setAccessible(Boolean accessible) {
        this.accessible = accessible;
        return this;
    }

    public Category setSeatShape(SeatShape seatShape) {
        this.seatShape = seatShape;
        return this;
    }
}
