package test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import io.seats.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.seats.SeatShape.STAR;
import static io.seats.SeatingChartMode.STATIC;
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
                .setOnObjectSelected(object -> Log.i(MainActivity.class.toString(), object.id))
                .setPricing(new SeatingChartTicketTypesPricing("2",
                        new SeatingChartTicketTypePricing(43, "a", "Adult"),
                        new SeatingChartTicketTypePricing(53, "child")
                ))
                .setPriceFormatter(price -> price + "€")
                .setMessages(messages)
                .setSelectBestAvailable(new BestAvailable().setNumberForTicketType("a", 2))
                .setShowRowLines(true)
                .setShowLegend(true)
                .setLegend(new Legend().setHideNonSelectableCategories(true).setHidePricing(true))
                .setShowActiveSectionTooltip(false)
                .setShowViewFromYourSeat(false)
                .setSelectionValidators(noOrphanSeats(), consecutiveSeats())
                .setCategories(
                        new Category().setKey("R").setColor("red").setLabel("Category 1").setAccessible(true).setSeatShape(STAR)
                )
                .setObjectCategories(objectCategories);
        setContentView(new SeatingChart(config, getApplicationContext()));
    }

}
