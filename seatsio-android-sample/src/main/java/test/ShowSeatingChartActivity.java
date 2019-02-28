package test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import io.seats.seatingChart.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.seats.seatingChart.SelectionValidator.consecutiveSeats;
import static io.seats.seatingChart.SelectionValidator.noOrphanSeats;

public class ShowSeatingChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Map<String, String> messages = new LinkedHashMap<>();
        messages.put("A", "lolzor");
        Map<String, String> objectCategories = new LinkedHashMap<>();
        messages.put("A-1", "R");
        messages.put("A-2", "R");
        Map<String, String> extraConfig = new LinkedHashMap<>();
        extraConfig.put("color", "blue");
        SeatingChartConfig config = new SeatingChartConfig()
                .setPublicKey("publicDemoKey")
                .setEvent("smallTheatreEvent1")
                .setOnObjectSelected((object, ticketType) -> Log.i(ShowSeatingChartActivity.class.toString(), "Selected " + object.id + " TT " + ticketType.ticketType))
                .setOnObjectDeselected((object, ticketType) -> Log.i(ShowSeatingChartActivity.class.toString(), "Deselected " + object.id + " TT " + ticketType.ticketType))
                .setOnObjectClicked(object -> Log.i(ShowSeatingChartActivity.class.toString(), "Clicked " + object.id))
                .setOnBestAvailableSelected((objects, nextToEachOther) -> Log.i(ShowSeatingChartActivity.class.toString(), "Best available selected " + nextToEachOther))
                .setOnBestAvailableSelectionFailed(() -> Log.i(ShowSeatingChartActivity.class.toString(), "Best available failed"))
                .setOnSelectionValid(() -> Log.i(ShowSeatingChartActivity.class.toString(), "Selection valid"))
                .setOnSelectionInvalid((violations) -> Log.i(ShowSeatingChartActivity.class.toString(), "Selection invalid " + violations))
                .setOnSelectedObjectBooked(object -> Log.i(ShowSeatingChartActivity.class.toString(), "Booked " + object.id))
                .setOnChartRendered((chart) -> {
                    chart.listSelectedObjects(objects -> Log.i(ShowSeatingChartActivity.class.toString(), objects.toString()));
                    chart.findObject("Adfsqs\"'fd-1",
                            object -> Log.i(ShowSeatingChartActivity.class.toString(), object.toString()),
                            () -> Log.i(ShowSeatingChartActivity.class.toString(), "not found"));
                    chart.listCategories(categories -> Log.i(ShowSeatingChartActivity.class.toString(), categories.toString()));
                    chart.getHoldToken(holdToken -> Log.i(ShowSeatingChartActivity.class.toString(), holdToken));
                })
                .setOnChartRenderingFailed((chart) -> Log.i(ShowSeatingChartActivity.class.toString(), "nonono"))
                .setPricing(new SeatingChartTicketTypesPricing("2",
                        new SeatingChartTicketTypePricing(43, "a", "Adult"),
                        new SeatingChartTicketTypePricing(53, "child")
                ))
                .setPriceFormatter(price -> price + "€")
                .setMessages(messages)
                .setShowRowLines(true)
                .setShowLegend(true)
                .setLegend(new Legend().setHideNonSelectableCategories(true).setHidePricing(true))
                .setShowActiveSectionTooltip(false)
                .setShowViewFromYourSeat(false)
                .setSelectionValidators(noOrphanSeats(), consecutiveSeats())
                .setHoldOnSelect(true)
                .setHoldOnSelectForGAs(true)
                .setOnHoldSucceeded((objects, ticketTypes) -> Log.i(ShowSeatingChartActivity.class.toString(), "Hold succeeded " + objects))
                .setOnHoldFailed((objects, ticketTypes) -> Log.i(ShowSeatingChartActivity.class.toString(), "Hold failed " + objects))
                .setOnReleaseHoldSucceeded((objects, ticketTypes) -> Log.i(ShowSeatingChartActivity.class.toString(), "Release hold succeeded " + objects))
                .setOnReleaseHoldFailed((objects, ticketTypes) -> Log.i(ShowSeatingChartActivity.class.toString(), "Release hold failed " + objects))
                .setSectionColor("(section, dflt, extraConfig) => extraConfig.color")
                .setExtraConfig(extraConfig);
        setContentView(new SeatingChart(config, getApplicationContext()));
    }

}
