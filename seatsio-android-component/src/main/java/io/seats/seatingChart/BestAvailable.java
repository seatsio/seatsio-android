package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class BestAvailable {

    @Expose
    public Integer number;

    @Expose
    public List<String> category;

    @Expose
    public Boolean clearSelection;

    @Expose
    public Map<String, Integer> ticketTypes;

    public BestAvailable setNumber(int number) {
        this.number = number;
        return this;
    }

    public BestAvailable setCategories(String... categories) {
        this.category = asList(categories);
        return this;
    }

    public BestAvailable setClearSelection(boolean clearSelection) {
        this.clearSelection = clearSelection;
        return this;
    }

    public BestAvailable setNumberForTicketType(String ticketType, int number) {
        if (ticketTypes == null) {
            ticketTypes = new HashMap<>();
        }
        this.ticketTypes.put(ticketType, number);
        return this;
    }
}
