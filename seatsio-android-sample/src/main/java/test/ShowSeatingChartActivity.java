package test;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import io.seats.seatingChart.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
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
        DecimalFormat priceFormat = new DecimalFormat();
        priceFormat.setMinimumFractionDigits(2);
        priceFormat.setMaximumFractionDigits(2);
        SeatingChartConfig config = new SeatingChartConfig().setColorScheme(ColorScheme.DARK)
                .setWorkspaceKey("publicDemoKey")
                .setEvent("fa78299a-6b61-4bf3-99c8-8434a79be17e")
                .setSession(START)
                .setOnObjectSelected((object, ticketType) -> Log.i(LOG_PREFIX, "Selected " + object.id + " TT " + ticketType.ticketType))
                .setOnObjectDeselected((object, ticketType) -> Log.i(LOG_PREFIX, "Deselected " + object.id + " TT " + ticketType.ticketType))
                .setOnChartRendered((chart -> {
                    chart.listSelectedObjects(objects -> Log.i(LOG_PREFIX, objects.toString()));
                    chart.getReportBySelectability(report -> Log.i(LOG_PREFIX, report.toString()));
                    chart.findObject("Adfsqs\"'fd-1",
                            object -> Log.i(LOG_PREFIX, object.toString()),
                            () -> Log.i(LOG_PREFIX, "not found"));
                }))
                .setOnChartRerenderingStarted(chart -> Log.i(LOG_PREFIX, "chart re-rendering started"))
                .setPricing(new SeatsioPricing(List.of(
                        new PricingForCategory("13", new SimplePrice(80f, 120f)),
                        new PricingForCategory("10", new TicketTypesPrice(
                                new TicketTypePricing(20.0f, "child").setOriginalPrice(25f),
                                new TicketTypePricing(30.5f, "adult").setOriginalPrice(35f))),
                        new PricingForCategory("11", new TicketTypesPrice(
                                new TicketTypePricing(20.0f, "child"),
                                new TicketTypePricing(30.5f, "adult"))
                        ),
                        new PricingForChart(new ObjectPrice(List.of("VIP SEATS-A-1", "VIP SEATS-A-2", "VIP SEATS-A-3"), 54f, 76f).setFee(5.5f)),
                        new PricingForChart(new ObjectPrice(List.of("VIP SEATS-B-1", "VIP SEATS-B-2", "VIP SEATS-B-3"), List.of(
                                new TicketTypePricing(20.0f, "child"),
                                new TicketTypePricing(30.5f, "adult")
                        ))),
                        new PricingForCategory("13", new ChannelPrice(List.of(
                                new ChannelPricing("d0b3e5e6-5089-1cfa-2e1b-4123a544051e", 55f)
                        ), 50f, 60f))))
                        .setPriceFormatter((price) -> "€" + priceFormat.format(price))
                        .setAllFeesIncluded(false)
                )
                .setCategoryFilter(new CategoryFilter().setEnabled(true))
                .setOnBestAvailableSelected((objects, nextToEachOther) -> Log.i(LOG_PREFIX, "Best available selected " + nextToEachOther))
                .setOnBestAvailableSelectionFailed(() -> Log.i(LOG_PREFIX, "Best available failed"))
                .setOnSelectionValid(() -> Log.i(LOG_PREFIX, "Selection valid"))
                .setOnSelectionInvalid((violations) -> Log.i(LOG_PREFIX, "Selection invalid " + violations))
                .setOnHoldCallsInProgress(() -> Log.i(LOG_PREFIX, "Hold calls in progress"))
                .setOnHoldCallsComplete(() -> Log.i(LOG_PREFIX, "Hold calls complete"))
                .setOnSelectedObjectBooked(object -> Log.i(LOG_PREFIX, "Booked " + object.id))
                .setOnSelectedObjectUnavailable(object -> Log.i(LOG_PREFIX, "Unavailable " + object.id))
                .setOnChartRenderingFailed((chart) -> Log.i(LOG_PREFIX, "nonono"))
                .setOnHoldSucceeded((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Hold succeeded " + objects))
                .setOnHoldFailed((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Hold failed " + objects))
                .setOnReleaseHoldSucceeded((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Release hold succeeded " + objects))
                .setOnReleaseHoldFailed((objects, ticketTypes) -> Log.i(LOG_PREFIX, "Release hold failed " + objects))
                .setObjectLabelJavaScriptFunction("(object, defaultLabel, extraConfig) => object.labels.own")
                .setObjectIconJavaScriptFunction("(object, defaultIcon, extraConfig) => defaultIcon")
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
        seatingChartView.setBackgroundColor(Color.BLACK);
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
