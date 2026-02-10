package io.seats.seatingChart;

import java.util.List;
import java.util.Map;

public class SeatsioObject {

    public String id;
    public Category category;
    public Channel channel;
    public Point center;
    public String label;
    public Labels labels;
    public Price pricing;
    public String status;
    public Boolean forSale;
    public Boolean selectable;
    public Boolean inSelectableChannel;
    public Boolean selected;
    public Boolean accessible;
    public Boolean companionSeat;
    public Boolean restrictedView;
    public Boolean disabledBySocialDistancingRules;
    public String selectedTicketType;
    public String objectType;
    public Map<String, Object> extraData;
    public SeatParent parent;
    public String displayObjectType;
    public String resaleListingId;
    public String floor;

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
        return pricing instanceof SimplePrice;
    }

    public SimplePrice getSimplePricing() {
        return (SimplePrice) pricing;
    }

    public TicketTypesPrice getTicketTypesPricing() {
        return (TicketTypesPrice) pricing;
    }

}
