package test;

import static io.seats.Region.EU;
import static io.seats.eventManager.EventManagerMode.MANAGE_OBJECT_STATUSES;
import static io.seats.seatingChart.ColorScheme.DARK;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.seats.eventManager.EventManagerConfig;
import io.seats.eventManager.EventManagerView;

public class ShowEventManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventManagerConfig config = new EventManagerConfig()
                .setSecretKey("demoKey")
                .setEvent("smallTheatreWithGAEvent")
                .setMode(MANAGE_OBJECT_STATUSES)
                .setLanguage("nl")
                .setObjectColor("(object, dflt, extraConfig) => object.channel ? 'blue': 'red'")
                .setTooltipInfo(object -> object.channel != null ? "in channel" : "not in channel")
                .setColorScheme(DARK)
                .setOnChartRenderingFailed((chart) -> {
                    Log.i("Seats.io", "whoops");
                });
        EventManagerView view = new EventManagerView(EU, config, getApplicationContext());
        view.setBackgroundColor(Color.BLACK);
        setContentView(view);
    }

}
