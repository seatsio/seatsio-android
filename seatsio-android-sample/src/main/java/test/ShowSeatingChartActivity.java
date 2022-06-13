package test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import io.seats.seatingChart.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static io.seats.Region.EU;
import static io.seats.seatingChart.SeatingChartSession.START;
import static io.seats.seatingChart.SeatingChartShowSectionContents.ALWAYS;
import static io.seats.seatingChart.SelectionValidator.consecutiveSeats;
import static io.seats.seatingChart.SelectionValidator.noOrphanSeats;

public class ShowSeatingChartActivity extends AppCompatActivity {

    public static final String LOG_PREFIX = "seatsio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Map<String, String> messages = new LinkedHashMap<>();
        messages.put("A", "lolzor");
        messages.put("A-1", "R");
        messages.put("A-2", "R");
        Map<String, String> extraConfig = new LinkedHashMap<>();
        extraConfig.put("color", "blue");
        AtomicBoolean changed = new AtomicBoolean(false);
        SeatingChartConfig config = new SeatingChartConfig()
                .setWorkspaceKey("publicDemoKey")
                .setEvent("smallTheatreEvent1")
                .setSelectedObjects("A-9")
                .setOnObjectSelected((object, ticketType) -> Log.i(LOG_PREFIX, "Selected " + object.id + " TT " + ticketType))
                .setOnObjectDeselected((object, ticketType) -> Log.i(LOG_PREFIX, "Deselected " + object.id + " TT " + ticketType))
                .setOnObjectClicked(object -> Log.i(LOG_PREFIX, "Clicked " + object.id))
                .setOnBestAvailableSelected((objects, nextToEachOther) -> Log.i(LOG_PREFIX, "Best available selected " + nextToEachOther))
                .setOnBestAvailableSelectionFailed(() -> Log.i(LOG_PREFIX, "Best available failed"))
                .setOnSelectionValid(() -> Log.i(LOG_PREFIX, "Selection valid"))
                .setOnSelectionInvalid((violations) -> Log.i(LOG_PREFIX, "Selection invalid " + violations))
                .setOnSelectedObjectBooked(object -> Log.i(LOG_PREFIX, "Booked " + object.id))
                .setOnChartRendered((chart) -> {
                    chart.listSelectedObjects(objects -> Log.i(LOG_PREFIX, objects.toString()));
                    chart.getReportBySelectability(report -> Log.i(LOG_PREFIX, report.toString()));
                    chart.findObject("Adfsqs\"'fd-1",
                            object -> Log.i(LOG_PREFIX, object.toString()),
                            () -> Log.i(LOG_PREFIX, "not found"));
                    chart.listCategories(categories -> Log.i(LOG_PREFIX, categories.toString()));
                    chart.getHoldToken(holdToken -> Log.i(LOG_PREFIX, holdToken));
                    if (!changed.get()) {
                        changed.set(true);
                        chart.changeConfig(new ConfigChange().setExtraConfig(extraConfig).setObjectColor("(object, dflt, extraConfig) => extraConfig.color"));
                    }
                    chart.isObjectInChannel("A-1", "bc122555-5d25-96ae-12b9-f6356b9e6226", result -> Log.i(LOG_PREFIX, result.toString()));
                })
                .setOnChartRenderingFailed((chart) -> Log.i(LOG_PREFIX, "nonono"))
                .setPricing(new PricingForCategory("2", new SimplePricing(34)))
                .setPriceFormatter(price -> price + "€")
                .setMessages(messages)
                .setShowLegend(true)
                .setMultiSelectEnabled(true)
                .setShowActiveSectionTooltip(false)
                .setShowViewFromYourSeat(false)
                .setSelectionValidators(noOrphanSeats(), consecutiveSeats())
                .setHoldOnSelectForGAs(true)
                .setShowSectionContents(ALWAYS)
                .setSession(START)
                .setOnHoldSucceeded((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Hold succeeded " + objects))
                .setOnHoldFailed((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Hold failed " + objects))
                .setOnReleaseHoldSucceeded((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Release hold succeeded " + objects))
                .setOnReleaseHoldFailed((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Release hold failed " + objects))
                .setObjectLabel("object => object.labels.own");
        setContentView(new SeatingChartView(EU, config, getApplicationContext()));
    }

}
