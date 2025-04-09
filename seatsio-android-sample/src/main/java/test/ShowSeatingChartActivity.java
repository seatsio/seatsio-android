package test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import io.seats.seatingChart.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

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
        AtomicBoolean changed = new AtomicBoolean(false);
        AtomicReference<SeatingChartView> seatingChartViewWrapper = null;
        SeatingChartConfig config = new SeatingChartConfig()
                .setWorkspaceKey("publicDemoKey")
                .setEvent("fa78299a-6b61-4bf3-99c8-8434a79be17e")
                .setSession(START)
                .setOnObjectSelected((object, ticketType) -> Log.i(LOG_PREFIX, "Selected " + object.id + " TT " + ticketType))
                .setOnObjectDeselected((object, ticketType) -> Log.i(LOG_PREFIX, "Deselected " + object.id + " TT " + ticketType))
                .setOnChartRendered((chart -> {
                    chart.listSelectedObjects(objects -> Log.i(LOG_PREFIX, objects.toString()));
                    chart.getReportBySelectability(report -> Log.i(LOG_PREFIX, report.toString()));
                    chart.findObject("Adfsqs\"'fd-1",
                            object -> Log.i(LOG_PREFIX, object.toString()),
                            () -> Log.i(LOG_PREFIX, "not found"));
                }))
                .setOnChartRerenderingStarted(chart -> Log.i(LOG_PREFIX, "chart re-rendering started"))
                .setPricing(
                        new PricingForCategory("10", new TicketTypesPricing(
                                new TicketTypePricing(20.0f, "child"),
                                new TicketTypePricing(30.0f, "adult"))),
                        new PricingForCategory("11", new TicketTypesPricing(
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
                .setObjectLabel((object, defaultLabel, extraConfig) -> object.labels.own)
                .setObjectIcon((object, defaultIcon, extraConfig) -> defaultIcon)
                .setPriceFormatter(price -> price + "€")
                .setShowLegend(true)
                .setShowSeatLabels(true)
                .setMultiSelectEnabled(true)
                .setShowActiveSectionTooltip(false)
                .setShowViewFromYourSeat(false)
                .setSectionColor((section, defaultValue, extraConfig) -> defaultValue)
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
                })
                .setHideSectionsNotForSale(true);
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);

        SeatingChartView seatingChartView = new SeatingChartView(EU, config, getApplicationContext());
        seatingChartViewWrapper = new AtomicReference<>(seatingChartView);
        Toolbar toolbar = new Toolbar(getApplicationContext());
        Button rerenderButton = new Button(getApplicationContext());
        rerenderButton.setText("Re-render");
        rerenderButton.setOnClickListener(v -> seatingChartView.rerender());
        toolbar.addView(rerenderButton);

        layout.addView(toolbar, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100, 0.0f));
        layout.addView(seatingChartView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));

        setContentView(layout);
    }
}
