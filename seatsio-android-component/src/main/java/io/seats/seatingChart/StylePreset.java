package io.seats.seatingChart;

import com.google.gson.annotations.SerializedName;

public enum StylePreset {

    @SerializedName("balance") BALANCE,
    @SerializedName("flathead") FLATHEAD,
    @SerializedName("bezels") BEZELS,
    @SerializedName("leaf") LEAF,
    @SerializedName("bubblegum") BUBBLEGUM;
}
