package io.seats.seatingChart;

import static io.seats.seatingChart.SeatingChartJavascriptInterface.GSON;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.util.function.Consumer;

import io.seats.Region;
import io.seats.SeatsioWebView;

public class SeatingChartView extends SeatsioWebView<SeatingChartView> {

    private final SeatingChartConfig config;

    @Override
    protected String toolName() {
        return "SeatingChart";
    }

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

    public void isObjectInChannel(String objectLabel, String channel, Consumer<Boolean> callback) {
        caller.callAsync(
                "chart.findObject(" + new Gson().toJson(objectLabel) + ").then(object => object.isInChannel(" + new Gson().toJson(channel) + "))",
                r -> callback.accept(GSON.fromJson(r, Boolean.class))
        );
    }

    public void getReportBySelectability(Consumer<ReportBySelectability> callback) {
        caller.callAsync(
                "chart.getReportBySelectability()",
                report -> callback.accept(GSON.fromJson(report, ReportBySelectability.class))
        );
    }

    public void changeConfig(ConfigChange configChange) {
        caller.call("chart.changeConfig(" + new Gson().toJson(configChange) + ")");
    }

    public void goToFloor(String floorName) {
        caller.call("chart.goToFloor('" + floorName + "')");
    }

    public void goToAllFloorsView() {
        caller.call("chart.goToAllFloorsView()");
    }

    public void zoomToFilteredCategories() {
        caller.call("chart.zoomToFilteredCategories()");
    }
}
