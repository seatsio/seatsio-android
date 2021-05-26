package io.seats.seatingChart;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class SeatsioObject {

    public String id;
    public Category category;
    public Point center;
    public String label;
    public Labels labels;
    public Pricing pricing;
    public String status;
    public Boolean forSale;
    public Boolean selectable;
    public Boolean inSelectableChannel;
    public Boolean selected;
    public String selectedTicketType;
    public String objectType;
    public Map<String, Object> extraData;

    public Integer capacity;
    public Integer numBooked;
    public Integer numFree;
    public Integer numSelected;
    public Map<String, Integer> selectionPerTicketType;

    public Category sectionCategory;
    public Integer numberOfSelectableObjects;
    public Integer numberOfSelectedObjects;
    public List<Category> selectableCategories;
    public Boolean isInteractive;

    private SeatingChartView chart;

    public SeatsioObject init(SeatingChartView chart) {
        this.chart = chart;
        return this;
    }

    public boolean isSimplePricing() {
        return pricing instanceof SimplePricing;
    }

    public SimplePricing getSimplePricing() {
        return (SimplePricing) pricing;
    }

    public TicketTypesPricing getTicketTypesPricing() {
        return (TicketTypesPricing) pricing;
    }

    public void select() {
        chart.selectObject(label);
    }

    public void deselect() {
        chart.deselectObject(label);
    }

    public void select(String ticketType) {
        chart.selectObject(label, ticketType);
    }

    public void deselect(String ticketType) {
        chart.deselectObject(label, ticketType);
    }

    public void pulse() {
        chart.pulseObject(label);
    }

    public void unpulse() {
        chart.unpulseObject(label);
    }

    public void isInChannel(String channel, Consumer<Boolean> callback) {
        chart.isObjectInChannel(label, channel, callback);
    }
}
