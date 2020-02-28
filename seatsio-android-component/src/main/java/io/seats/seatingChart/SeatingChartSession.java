package io.seats.seatingChart;

import com.google.gson.annotations.SerializedName;

public enum SeatingChartSession {

    @SerializedName("continue") CONTINUE,
    @SerializedName("start") START,
    @SerializedName("manual") MANUAL,
    @SerializedName("none") NONE,
}
