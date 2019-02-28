package io.seats.seatingChart;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.Expose;

import java.lang.reflect.Type;

abstract public class Pricing {

    @Expose
    public String category;

    Pricing(String category) {
        this.category = category;
    }

    static class PricingDeserializer implements JsonDeserializer<Pricing> {

        @Override
        public Pricing deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if(json.getAsJsonObject().has("ticketTypes")) {
                return context.deserialize(json, TicketTypesPricing.class);
            }
            return context.deserialize(json, SimplePricing.class);
        }
    }
}
