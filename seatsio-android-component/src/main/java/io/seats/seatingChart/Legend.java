package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class Legend {

    @Expose
    public Boolean hideNonSelectableCategories;

    @Expose
    public Boolean hidePricing;

    public Legend setHideNonSelectableCategories(boolean hideNonSelectableCategories) {
        this.hideNonSelectableCategories = hideNonSelectableCategories;
        return this;
    }

    public Legend setHidePricing(boolean hidePricing) {
        this.hidePricing = hidePricing;
        return this;
    }
}
