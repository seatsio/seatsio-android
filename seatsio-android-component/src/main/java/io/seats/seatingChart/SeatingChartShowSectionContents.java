package io.seats.seatingChart;

import com.google.gson.annotations.SerializedName;

public enum SeatingChartShowSectionContents {

    @SerializedName("auto") AUTO,
    @SerializedName("always") ALWAYS,
    @SerializedName("onlyAfterZoom") ONLY_AFTER_ZOOM,

}
