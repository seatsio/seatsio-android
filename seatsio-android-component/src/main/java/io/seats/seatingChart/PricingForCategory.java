package io.seats.seatingChart;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.Expose;

import java.lang.reflect.Type;

public class PricingForCategory {

    @Expose
    public String category;

    @Expose
    public Pricing pricing;

    public PricingForCategory(String category, Pricing pricing) {
        this.category = category;
        this.pricing = pricing;
    }

    public static class PricingForCategorySerializer implements JsonSerializer<PricingForCategory> {

        @Override
        public JsonElement serialize(PricingForCategory pricingForCategory, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject result = context.serialize(pricingForCategory.pricing).getAsJsonObject();
            result.addProperty("category", pricingForCategory.category);
            return result;
        }
    }
}
