package io.seats.seatingChart;

import com.google.gson.annotations.Expose;

import static io.seats.seatingChart.SelectionValidatorType.CONSECUTIVE_SEATS;
import static io.seats.seatingChart.SelectionValidatorType.NO_ORPHAN_SEATS;

public class SelectionValidator {

    @Expose
    public SelectionValidatorType type;

    private SelectionValidator(SelectionValidatorType type) {
        this.type = type;
    }

    public static SelectionValidator consecutiveSeats() {
        return new SelectionValidator(CONSECUTIVE_SEATS);
    }

    public static SelectionValidator noOrphanSeats() {
        return new SelectionValidator(NO_ORPHAN_SEATS);
    }
}
