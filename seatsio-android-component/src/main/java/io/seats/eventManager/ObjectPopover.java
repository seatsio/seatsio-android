package io.seats.eventManager;

import com.google.gson.annotations.Expose;

public class ObjectPopover {

    @Expose
    public Boolean showOrderId;

    @Expose
    public Boolean showTechnicalLabel;

    @Expose
    public Boolean showLabel;

    @Expose
    public Boolean showCategory;

    @Expose
    public Boolean showChannel;

    public ObjectPopover setShowOrderId(Boolean showOrderId) {
        this.showOrderId = showOrderId;
        return this;
    }

    public ObjectPopover setShowTechnicalLabel(Boolean showTechnicalLabel) {
        this.showTechnicalLabel = showTechnicalLabel;
        return this;
    }

    public ObjectPopover setShowLabel(Boolean showLabel) {
        this.showLabel = showLabel;
        return this;
    }

    public ObjectPopover setShowCategory(Boolean showCategory) {
        this.showCategory = showCategory;
        return this;
    }

    public ObjectPopover setShowChannel(Boolean showChannel) {
        this.showChannel = showChannel;
        return this;
    }
}
