package io.seats.seatingChart;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.seats.SeatsioWebView;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Consumer;

public class SeatingChartView extends SeatsioWebView {

    private final SeatingChartConfig config;

    public SeatingChartView(SeatingChartConfig config, Context context) {
        super(config.toJson(), new SeatingChartJavascriptInterface(config), context);
        this.config = config;
    }

    public SeatingChartView(SeatingChartConfig config, Context context, @Nullable AttributeSet attrs) {
        super(config.toJson(), new SeatingChartJavascriptInterface(config), context, attrs);
        this.config = config;
    }

    public SeatingChartView(SeatingChartConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(config.toJson(), new SeatingChartJavascriptInterface(config), context, attrs, defStyleAttr);
        this.config = config;
    }

    public SeatingChartView(SeatingChartConfig config, Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(config.toJson(), new SeatingChartJavascriptInterface(config), context, attrs, defStyleAttr, defStyleRes);
        this.config = config;
    }

    public void getHoldToken(Consumer<String> callback) {
        evaluateJavascript("chart.holdToken", callback::accept);
    }

    public void zoomToSelectedObjects() {
        evaluateJavascript("chart.zoomToSelectedObjects()", null);
    }

    public void selectBestAvailable(BestAvailable bestAvailable) {
        evaluateJavascript("chart.selectBestAvailable(" + new Gson().toJson(bestAvailable) + ")", null);
    }

    public void selectObjects(SelectedObject... objects) {
        evaluateJavascript("chart.selectObjects(" + new Gson().toJson(objects) + ")", null);
    }

    public void deselectObjects(SelectedObject... objects) {
        evaluateJavascript("chart.deselectObjects(" + new Gson().toJson(objects) + ")", null);
    }

    public void listSelectedObjects(Consumer<List<SeatsioObject>> callback) {
        asyncRequests.doRequest(
                "listSelectedObjects",
                objects -> {
                    Type listType = new TypeToken<List<SeatsioObject>>() {
                    }.getType();
                    callback.accept(new Gson().fromJson(objects, listType));
                }
        );
    }

    public void listCategories(Consumer<List<Category>> callback) {
        asyncRequests.doRequest(
                "listCategories",
                categories -> {
                    Type listType = new TypeToken<List<Category>>() {
                    }.getType();
                    callback.accept(new Gson().fromJson(categories, listType));
                }
        );
    }

    public void findObject(String label, Consumer<SeatsioObject> successCallback, Runnable errorCallback) {
        asyncRequests.doRequest(
                "findObject",
                label,
                object -> successCallback.accept(new Gson().fromJson(object, SeatsioObject.class)),
                errorCallback
        );
    }

    public void clearSelection(Runnable successCallback, Runnable errorCallback) {
        asyncRequests.doRequest(
                "clearSelection",
                object -> successCallback.run(),
                errorCallback
        );
    }

}
