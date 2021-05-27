package io.seats.seatingChart;

import android.content.Context;

import androidx.annotation.Nullable;

import android.util.AttributeSet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.seats.Region;
import io.seats.SeatsioWebView;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Consumer;

import static io.seats.seatingChart.SeatingChartJavascriptInterface.GSON;

public class SeatingChartView extends SeatsioWebView {

    private final SeatingChartConfig config;

    public SeatingChartView(Region region, SeatingChartConfig config, Context context) {
        super(region, config.toJson(), new SeatingChartJavascriptInterface(config), context);
        this.config = config;
    }

    public SeatingChartView(Region region, SeatingChartConfig config, Context context, @Nullable AttributeSet attrs) {
        super(region, config.toJson(), new SeatingChartJavascriptInterface(config), context, attrs);
        this.config = config;
    }

    public SeatingChartView(Region region, SeatingChartConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(region, config.toJson(), new SeatingChartJavascriptInterface(config), context, attrs, defStyleAttr);
        this.config = config;
    }

    public SeatingChartView(Region region, SeatingChartConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(region, config.toJson(), new SeatingChartJavascriptInterface(config), context, attrs, defStyleAttr, defStyleRes);
        this.config = config;
    }

    public void getHoldToken(Consumer<String> callback) {
        caller.call("chart.holdToken", callback);
    }

    public void zoomToSelectedObjects() {
        caller.call("chart.zoomToSelectedObjects()");
    }

    public void selectBestAvailable(BestAvailable bestAvailable) {
        caller.call("chart.selectBestAvailable(" + new Gson().toJson(bestAvailable) + ")");
    }

    public void selectObjects(SelectedObject... objects) {
        caller.call("chart.selectObjects(" + new Gson().toJson(objects) + ")");
    }

    public void deselectObjects(SelectedObject... objects) {
        caller.call("chart.deselectObjects(" + new Gson().toJson(objects) + ")");
    }

    public void selectObject(String objectLabel) {
        caller.call("chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.select())");
    }

    public void deselectObject(String objectLabel) {
        caller.call("chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.deselect())");
    }

    public void selectObject(String objectLabel, String ticketType) {
        caller.call("chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.select(" + new Gson().toJson(ticketType) + "))");
    }

    public void deselectObject(String objectLabel, String ticketType) {
        caller.call("chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.deselect(" + new Gson().toJson(ticketType) + "))");
    }

    public void pulseObject(String objectLabel) {
        caller.call("chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.pulse())");
    }

    public void unpulseObject(String objectLabel) {
        caller.call("chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.unpulse())");
    }

    public void isObjectInChannel(String objectLabel, String channel, Consumer<Boolean> callback) {
        caller.callAsync(
                "chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.isInChannel(" + new Gson().toJson(channel) + "))",
                r -> callback.accept(GSON.fromJson(r, Boolean.class))
        );
    }

    public void listSelectedObjects(Consumer<List<SeatsioObject>> callback) {
        caller.callAsync(
                "chart.listSelectedObjects()",
                objects -> {
                    Type listType = new TypeToken<List<SeatsioObject>>() {
                    }.getType();
                    List<SeatsioObject> seatsioObjects = GSON.fromJson(objects, listType);
                    callback.accept(setChart(seatsioObjects));
                }
        );
    }

    public void listCategories(Consumer<List<Category>> callback) {
        caller.callAsync(
                "chart.listCategories()",
                categories -> {
                    Type listType = new TypeToken<List<Category>>() {
                    }.getType();
                    callback.accept(GSON.fromJson(categories, listType));
                }
        );
    }

    public void findObject(String label, Consumer<SeatsioObject> successCallback, Runnable errorCallback) {
        caller.callAsync(
                "chart.findObject(" + GSON.toJson(label) + ")",
                object -> {
                    SeatsioObject seatsioObject = GSON.fromJson(object, SeatsioObject.class);
                    successCallback.accept(seatsioObject.init(this));
                },
                errorCallback
        );
    }

    public void clearSelection(Runnable successCallback, Runnable errorCallback) {
        caller.callAsync(
                "chart.clearSelection()",
                object -> successCallback.run(),
                errorCallback
        );
    }

    public void changeConfig(ConfigChange configChange) {
        caller.call("chart.changeConfig(" + new Gson().toJson(configChange) + ")");
    }

    private List<SeatsioObject> setChart(List<SeatsioObject> objects) {
        objects.forEach(object -> object.init(this));
        return objects;
    }
}
