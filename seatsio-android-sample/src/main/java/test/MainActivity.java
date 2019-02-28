package test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import io.seats.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.seats.SelectionValidator.consecutiveSeats;
import static io.seats.SelectionValidator.noOrphanSeats;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Map<String, String> messages = new LinkedHashMap<>();
        messages.put("A", "lolzor");
        Map<String, String> objectCategories = new LinkedHashMap<>();
        messages.put("A-1", "R");
        messages.put("A-2", "R");
        SeatingChartConfig config = new SeatingChartConfig()
                .setPublicKey("publicDemoKey")
                .setEvent("smallTheatreEvent1")
                .setOnObjectSelected((object, ticketType) -> Log.i(MainActivity.class.toString(), "Selected " + object.id + " TT " + ticketType.ticketType))
                .setOnObjectDeselected((object, ticketType) -> Log.i(MainActivity.class.toString(), "Deselected " + object.id + " TT " + ticketType.ticketType))
                .setOnObjectClicked(object -> Log.i(MainActivity.class.toString(), "Clicked " + object.id))
                .setOnBestAvailableSelected((objects, nextToEachOther) -> Log.i(MainActivity.class.toString(), "Best available selected " + nextToEachOther))
                .setOnBestAvailableSelectionFailed(() -> Log.i(MainActivity.class.toString(), "Best available failed"))
                .setOnSelectionValid(() -> Log.i(MainActivity.class.toString(), "Selection valid"))
                .setOnSelectionInvalid((violations) -> Log.i(MainActivity.class.toString(), "Selection invalid " + violations))
                .setOnSelectedObjectBooked(object -> Log.i(MainActivity.class.toString(), "Booked " + object.id))
                .setOnChartRendered((chart) -> {
                    chart.listSelectedObjects(objects -> Log.i(MainActivity.class.toString(), objects.toString()));
                    chart.findObject("Adfsqs\"'fd-1",
                            object -> Log.i(MainActivity.class.toString(), object.toString()),
                            () -> Log.i(MainActivity.class.toString(), "not found"));
                    chart.listCategories(categories -> Log.i(MainActivity.class.toString(), categories.toString()));
                    chart.getHoldToken(holdToken -> Log.i(MainActivity.class.toString(), holdToken));
                })
                .setOnChartRenderingFailed((chart) -> Log.i(MainActivity.class.toString(), "nonono"))
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
                .setSelectionValidators(noOrphanSeats(), consecutiveSeats());
        setContentView(new SeatingChart(config, getApplicationContext()));
    }

}
