package test;

import static io.seats.Region.EU;
import static io.seats.eventManager.EventManagerMode.SELECT;
import static io.seats.seatingChart.ColorScheme.DARK;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.seats.eventManager.EventManagerConfig;
import io.seats.eventManager.EventManagerView;
import io.seats.eventManager.SelectModeConfig;
import io.seats.eventManager.SelectModeView;

public class ShowEventManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventManagerConfig config = new SelectModeConfig()
                .setObjectIconJavaScriptFunction("(object, defaultIcon, extraConfig) => defaultIcon")
                .setMaxSelectedObjects(4)
                .setSecretKey("...")
                .setEvent("fa78299a-6b61-4bf3-99c8-8434a79be17e")
                .setMode(SELECT)
                .setLanguage("nl")
                .setObjectColorJavaScriptFunction("(object, defaultColor, extraConfig) -> object.accessible ? 'blue': 'red''")
                .setTooltipInfo(object -> object.channel != null ? "in channel" : "not in channel")
                .setColorScheme(DARK)
                .setOnChartRenderingFailed((chart) -> Log.i("Seats.io", "whoops"));
        EventManagerView view = new SelectModeView(EU, (SelectModeConfig)config, getApplicationContext());
        view.setBackgroundColor(Color.BLACK);
        setContentView(view);
    }
}
