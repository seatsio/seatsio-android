package io.seats.seatingChart;

import java.util.List;
import java.util.Map;

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

    public boolean isSimplePricing() {
        return pricing instanceof SimplePricing;
    }

    public SimplePricing getSimplePricing() {
        return (SimplePricing) pricing;
    }

    public TicketTypesPricing getTicketTypesPricing() {
        return (TicketTypesPricing) pricing;
    }
}
