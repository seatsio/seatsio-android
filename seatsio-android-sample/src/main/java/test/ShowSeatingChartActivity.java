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
        AtomicBoolean changed = new AtomicBoolean(false);
        SeatingChartConfig config = new SeatingChartConfig()
                .setWorkspaceKey("publicDemoKey")
                .setEvent("smallTheatreWithGAEvent")
                .setSession(START)
                .setOnObjectSelected((object, ticketType) -> Log.i(LOG_PREFIX, "Selected " + object.id + " TT " + ticketType))
                .setOnObjectDeselected((object, ticketType) -> Log.i(LOG_PREFIX, "Deselected " + object.id + " TT " + ticketType))
                .setSelectedObjects("A-1")
                .setOnChartRendered((chart -> {
                    chart.listSelectedObjects(objects -> Log.i(LOG_PREFIX, objects.toString()));
                    chart.getReportBySelectability(report -> Log.i(LOG_PREFIX, report.toString()));
                    chart.findObject("Adfsqs\"'fd-1",
                            object -> Log.i(LOG_PREFIX, object.toString()),
                            () -> Log.i(LOG_PREFIX, "not found"));
                }))
                .setPricing(
                        new PricingForCategory("1", new TicketTypesPricing(
                                new TicketTypePricing(20.0f, "child"),
                                new TicketTypePricing(30.0f, "adult"))),
                        new PricingForCategory("2", new TicketTypesPricing(
                                new TicketTypePricing(20.0f, "child"),
                                new TicketTypePricing(30.0f, "adult")
                        ))
                )
                .setCategoryFilter(new CategoryFilter().setEnabled(true))
                .setOnBestAvailableSelected((objects, nextToEachOther) -> Log.i(LOG_PREFIX, "Best available selected " + nextToEachOther))
                .setOnBestAvailableSelectionFailed(() -> Log.i(LOG_PREFIX, "Best available failed"))
                .setOnSelectionValid(() -> Log.i(LOG_PREFIX, "Selection valid"))
                .setOnSelectionInvalid((violations) -> Log.i(LOG_PREFIX, "Selection invalid " + violations))
                .setOnHoldCallsInProgress(() -> Log.i(LOG_PREFIX, "Hold calls in progress"))
                .setOnHoldCallsComplete(() -> Log.i(LOG_PREFIX, "Hold calls complete"))
                .setOnSelectedObjectBooked(object -> Log.i(LOG_PREFIX, "Booked " + object.id))
                .setOnChartRenderingFailed((chart) -> Log.i(LOG_PREFIX, "nonono"))
                .setOnHoldSucceeded((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Hold succeeded " + objects))
                .setOnHoldFailed((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Hold failed " + objects))
                .setOnReleaseHoldSucceeded((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Release hold succeeded " + objects))
                .setOnReleaseHoldFailed((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Release hold failed " + objects))
                .setObjectLabel("object => object.labels.own")
                .setPriceFormatter(price -> price + "€")
                .setMessages(messages)
                .setShowLegend(true)
                .setShowSeatLabels(true)
                .setMultiSelectEnabled(true)
                .setShowActiveSectionTooltip(false)
                .setShowViewFromYourSeat(false)
                .setSelectionValidators(noOrphanSeats(), consecutiveSeats())
                .setHoldOnSelectForGAs(true)
                .setShowSectionContents(ALWAYS)
                .setOnPlacesPrompt((params, callback) -> {
                    Log.i(LOG_PREFIX, params.toString());
                    // show a dialog here
                    callback.accept(3);
                })
                .setOnTicketTypePrompt((params, callback) -> {
                    Log.i(LOG_PREFIX, params.toString());
                    // show a dialog here
                    callback.accept("adult");
                })
                .setOnPlacesWithTicketTypesPrompt((params, callback) -> {
                    Log.i(LOG_PREFIX, params.toString());
                    // show a dialog here
                    callback.accept(Map.of("adult", 2));
                });
        setContentView(new SeatingChartView(EU, config, getApplicationContext()));
    }
}
