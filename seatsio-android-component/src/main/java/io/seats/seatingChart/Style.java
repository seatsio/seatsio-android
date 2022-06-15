package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

public class Style {

    @Expose
    public Font font;

    @Expose
    public BorderRadius borderRadius;

    @Expose
    public Border border;

    @Expose
    public Padding padding;

    @Expose
    public ButtonFace buttonFace;

    @Expose
    public FontWeight fontWeight;

    public Style setFont(Font font) {
        this.font = font;
        return this;
    }

    public Style setFontWeight(FontWeight fontWeight) {
        this.fontWeight = fontWeight;
        return this;
    }

    public Style setBorderRadius(BorderRadius borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    public Style setBorder(Border border) {
        this.border = border;
        return this;
    }

    public Style setPadding(Padding padding) {
        this.padding = padding;
        return this;
    }

    public Style setButtonFace(ButtonFace buttonFace) {
        this.buttonFace = buttonFace;
        return this;
    }
}
