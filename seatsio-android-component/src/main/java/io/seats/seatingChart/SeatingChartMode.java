package io.seats.seatingChart;

import com.google.gson.annotations.SerializedName;

public enum SeatingChartMode {

    @SerializedName("normal") NORMAL, @SerializedName("static") STATIC, @SerializedName("print") PRINT;
}
