package io.seats;

import com.google.gson.annotations.SerializedName;

public enum SelectionValidatorType {

    @SerializedName("consecutiveSeats") CONSECUTIVE_SEATS, @SerializedName("noOrphanSeats") NO_ORPHAN_SEATS
}
