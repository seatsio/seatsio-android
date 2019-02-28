package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class ObjectTooltip {

    @Expose
    public Boolean showActionHint;

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
    public Boolean confirmSelectionOnMobile;

    public ObjectTooltip setShowActionHint(boolean showActionHint) {
        this.showActionHint = showActionHint;
        return this;
    }

    public ObjectTooltip setShowAvailability(boolean showAvailability) {
        this.showAvailability = showAvailability;
        return this;
    }

    public ObjectTooltip setShowCategory(boolean showCategory) {
        this.showCategory = showCategory;
        return this;
    }

    public ObjectTooltip setShowLabel(boolean showLabel) {
        this.showLabel = showLabel;
        return this;
    }

    public ObjectTooltip setShowPricing(boolean showPricing) {
        this.showPricing = showPricing;
        return this;
    }

    public ObjectTooltip setShowUnavailableNotice(boolean showUnavailableNotice) {
        this.showUnavailableNotice = showUnavailableNotice;
        return this;
    }

    public ObjectTooltip setStylizedLabel(boolean stylizedLabel) {
        this.stylizedLabel = stylizedLabel;
        return this;
    }

    public ObjectTooltip setConfirmSelectionOnMobile(boolean confirmSelectionOnMobile) {
        this.confirmSelectionOnMobile = confirmSelectionOnMobile;
        return this;
    }
}
