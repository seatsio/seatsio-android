package test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import io.seats.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SeatingChartConfig config = new SeatingChartConfig()
                .withPublicKey("publicDemoKey")
                .withEvent("smallTheatreEvent2")
                .withPricing(new SeatingChartTicketTypesPricing("2",
                        new SeatingChartTicketTypePricing(43, "a", "Adult"),
                        new SeatingChartTicketTypePricing(53, "child")
                ))
                .withOnObjectSelected(object -> Log.i(MainActivity.class.toString(), object.id))
                .withPriceFormatter(price -> price + "€")
                .withSelectedObjects(new SelectedObject("General Admission", "a", 3));
        setContentView(new SeatingChart(config, getApplicationContext()));
    }

}
