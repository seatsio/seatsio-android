package test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.seats.eventManager.EventManagerConfig;
import io.seats.eventManager.EventManagerView;

import static io.seats.eventManager.EventManagerMode.MANAGE_OBJECT_STATUSES;

public class ShowEventManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventManagerConfig config = new EventManagerConfig()
                .setSecretKey("...")
                .setEvent("smallTheatreEvent1")
                .setMode(MANAGE_OBJECT_STATUSES)
                .setLanguage("nl");
        setContentView(new EventManagerView(config, getApplicationContext()));
    }

}
