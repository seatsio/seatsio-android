package test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import io.seats.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.seats.EventManagerMode.MANAGE_OBJECT_STATUSES;
import static io.seats.SelectionValidator.consecutiveSeats;
import static io.seats.SelectionValidator.noOrphanSeats;

public class ShowEventManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventManagerConfig config = new EventManagerConfig()
                .setSecretKey("demoKey")
                .setEvent("smallTheatreEvent1")
                .setMode(MANAGE_OBJECT_STATUSES)
                .setLanguage("nl");
        setContentView(new EventManager(config, getApplicationContext()));
    }

}
