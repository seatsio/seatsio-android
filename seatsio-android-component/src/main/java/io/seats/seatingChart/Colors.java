package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class Colors {

    @Expose
    public String colorSelected;

    @Expose
    public String cursorTooltipBackgroundColor;

    @Expose
    public String colorTitle;

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
}
