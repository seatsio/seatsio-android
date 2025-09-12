package io.seats.seatingChart;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.Expose;

import java.lang.reflect.Type;

public class PricingForChart implements Pricing {

    @Expose
    public Price pricing;

    public PricingForChart(Price pricing) {
        this.pricing = pricing;
    }

    public static class PricingForChartSerializer implements JsonSerializer<PricingForChart> {

        @Override
        public JsonElement serialize(PricingForChart pricingForChart, Type typeOfSrc, JsonSerializationContext context) {
            return context.serialize(pricingForChart.pricing).getAsJsonObject();
        }
    }
}
