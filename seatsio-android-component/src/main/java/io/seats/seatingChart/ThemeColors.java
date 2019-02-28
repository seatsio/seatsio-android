package io.seats.seatingChart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThemeColors {

    @Expose
    @SerializedName("theme-cursor-tooltip-background-color")
    public String cursorTooltipBackgroundColor;

    @Expose
    @SerializedName("theme-color-selected")
    public String colorSelected;

    public ThemeColors setCursorTooltipBackgroundColor(String cursorTooltipBackgroundColor) {
        this.cursorTooltipBackgroundColor = cursorTooltipBackgroundColor;
        return this;
    }

    public ThemeColors setColorSelected(String colorSelected) {
        this.colorSelected = colorSelected;
        return this;
    }
}
