package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class Colors {

    @Expose
    public String colorSelected;

    @Expose
    public String cursorTooltipBackgroundColor;

    @Expose
    public String colorTitle;

    @Expose
    public String availableObjectColor;

    @Expose
    public String selectedObjectColor;

    @Expose
    public String errorColor;

    public Colors setColorSelected(String colorSelected) {
        this.colorSelected = colorSelected;
        return this;
    }

    public Colors setCursorTooltipBackgroundColor(String cursorTooltipBackgroundColor) {
        this.cursorTooltipBackgroundColor = cursorTooltipBackgroundColor;
        return this;
    }

    public Colors setColorTitle(String colorTitle) {
        this.colorTitle = colorTitle;
        return this;
    }

    public Colors setAvailableObjectColor(String availableObjectColor) {
        this.availableObjectColor = availableObjectColor;
        return this;
    }

    public Colors setSelectedObjectColor(String selectedObjectColor) {
        this.selectedObjectColor = selectedObjectColor;
        return this;
    }

    public Colors setErrorColor(String errorColor) {
        this.errorColor = errorColor;
        return this;
    }
}
