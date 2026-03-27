package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class BestAvailableForHolding {

    @Expose
    public Integer number;

    @Expose
    public List<String> categories;

    @Expose
    public String zone;

    @Expose
    public List<String> sections;

    @Expose
    public Integer accessibleSeats;

    @Expose
    public Map<String, Integer> ticketTypes;

    public BestAvailableForHolding setNumber(int number) {
        this.number = number;
        return this;
    }

    public BestAvailableForHolding setCategories(String... categories) {
        this.categories = asList(categories);
        return this;
    }

    public BestAvailableForHolding setZone(String zone) {
        this.zone = zone;
        return this;
    }

    public BestAvailableForHolding setSections(String... sections) {
        this.sections = asList(sections);
        return this;
    }

    public BestAvailableForHolding setAccessibleSeats(int accessibleSeats) {
        this.accessibleSeats = accessibleSeats;
        return this;
    }

    public BestAvailableForHolding setNumberForTicketType(String ticketType, int number) {
        if (ticketTypes == null) {
            ticketTypes = new HashMap<>();
        }
        this.ticketTypes.put(ticketType, number);
        return this;
    }
}
