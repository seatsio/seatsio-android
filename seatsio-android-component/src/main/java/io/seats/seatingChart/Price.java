package io.seats.seatingChart;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

abstract public class Price {

    public static class PriceDeserializer implements JsonDeserializer<Price> {

        @Override
        public Price deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject asJsonObject = json.getAsJsonObject();
            if (asJsonObject.has("objects")) {
                return context.deserialize(json, ObjectPrice.class);
            } else if (asJsonObject.has("ticketTypes")) {
                return context.deserialize(json, TicketTypesPrice.class);
            } else if (asJsonObject.has("channels")) {
                return context.deserialize(json, ChannelPrice.class);
            }
            return context.deserialize(json, SimplePrice.class);
        }
    }
}
