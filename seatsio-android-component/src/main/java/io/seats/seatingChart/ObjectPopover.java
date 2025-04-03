package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class ObjectPopover {

    @Expose
    public Boolean showAvailability;

    @Expose
    public Boolean showCategory;

    @Expose
    public Boolean showLabel;

    @Expose
    public Boolean showPricing;

    @Expose
    public Boolean showUnavailableNotice;

    @Expose
    public Boolean stylizedLabel;

    @Expose
    public String confirmSelection;

    @Expose
    public Boolean confirmTicketTypeSelection;

    public ObjectPopover setShowAvailability(Boolean showAvailability) {
        this.showAvailability = showAvailability;
        return this;
    }

    public ObjectPopover setShowCategory(Boolean showCategory) {
        this.showCategory = showCategory;
        return this;
    }

    public ObjectPopover setShowLabel(Boolean showLabel) {
        this.showLabel = showLabel;
        return this;
    }

    public ObjectPopover setShowPricing(Boolean showPricing) {
        this.showPricing = showPricing;
        return this;
    }

    public ObjectPopover setShowUnavailableNotice(Boolean showUnavailableNotice) {
        this.showUnavailableNotice = showUnavailableNotice;
        return this;
    }

    public ObjectPopover setStylizedLabel(Boolean stylizedLabel) {
        this.stylizedLabel = stylizedLabel;
        return this;
    }

    public ObjectPopover setConfirmSelection(String confirmSelection) {
        this.confirmSelection = confirmSelection;
        return this;
    }

    public ObjectPopover setConfirmTicketTypeSelection(Boolean confirmTicketTypeSelection) {
        this.confirmTicketTypeSelection = confirmTicketTypeSelection;
        return this;
    }
}
