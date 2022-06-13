package test;

import static io.seats.Region.EU;
import static io.seats.seatingChart.SeatingChartSession.START;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import io.seats.seatingChart.CategoryFilter;
import io.seats.seatingChart.SeatingChartConfig;
import io.seats.seatingChart.SeatingChartView;

public class ShowSeatingChartActivity extends AppCompatActivity {

    private static String LOGGING_TAG = "seatsio";

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
                .setEvent("multiFloorEvent")
                .setOnFloorChanged(floor -> Log.i("seatsio", floor.categories.get(0).color));
        setContentView(new SeatingChartView(EU, config, getApplicationContext()));
    }

}
