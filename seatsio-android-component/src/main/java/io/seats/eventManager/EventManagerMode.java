package io.seats.eventManager;

import com.google.gson.annotations.SerializedName;

public enum EventManagerMode {

    @SerializedName("manageObjectStatuses") MANAGE_OBJECT_STATUSES,
    @SerializedName("manageForSaleConfig") MANAGE_FOR_SALE_CONFIG,
    @SerializedName("manageTableBooking") MANAGE_TABLE_BOOKING,
    @SerializedName("manageChannels") MANAGE_CHANNELS,
    @SerializedName("manageCategories") MANAGE_CATEGORIES,
    @SerializedName("select") SELECT,
    @SerializedName("static") STATIC;
}
