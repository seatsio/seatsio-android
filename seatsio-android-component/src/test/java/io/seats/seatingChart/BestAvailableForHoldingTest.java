package io.seats.seatingChart;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Test;

public class BestAvailableForHoldingTest {

    @Test
    public void serializesWithAllFields() {
        BestAvailableForHolding bestAvailable = new BestAvailableForHolding()
                .setNumber(3)
                .setCategories("cat1", "cat2")
                .setZone("zone1")
                .setSections("section1", "section2")
                .setAccessibleSeats(2)
                .setNumberForTicketType("adult", 2)
                .setNumberForTicketType("child", 1);

        String json = new Gson().toJson(bestAvailable);
        JsonObject parsed = JsonParser.parseString(json).getAsJsonObject();

        assertThat(parsed.get("number").getAsInt()).isEqualTo(3);
        assertThat(parsed.getAsJsonArray("categories")).hasSize(2);
        assertThat(parsed.getAsJsonArray("categories").get(0).getAsString()).isEqualTo("cat1");
        assertThat(parsed.getAsJsonArray("categories").get(1).getAsString()).isEqualTo("cat2");
        assertThat(parsed.get("zone").getAsString()).isEqualTo("zone1");
        assertThat(parsed.getAsJsonArray("sections")).hasSize(2);
        assertThat(parsed.getAsJsonArray("sections").get(0).getAsString()).isEqualTo("section1");
        assertThat(parsed.getAsJsonArray("sections").get(1).getAsString()).isEqualTo("section2");
        assertThat(parsed.get("accessibleSeats").getAsInt()).isEqualTo(2);
        assertThat(parsed.getAsJsonObject("ticketTypes").get("adult").getAsInt()).isEqualTo(2);
        assertThat(parsed.getAsJsonObject("ticketTypes").get("child").getAsInt()).isEqualTo(1);
    }

    @Test
    public void serializesWithOnlyNumber() {
        BestAvailableForHolding bestAvailable = new BestAvailableForHolding()
                .setNumber(5);

        String json = new Gson().toJson(bestAvailable);
        JsonObject parsed = JsonParser.parseString(json).getAsJsonObject();

        assertThat(parsed.get("number").getAsInt()).isEqualTo(5);
        assertThat(parsed.get("categories")).isNull();
        assertThat(parsed.get("zone")).isNull();
        assertThat(parsed.get("sections")).isNull();
        assertThat(parsed.get("accessibleSeats")).isNull();
        assertThat(parsed.get("ticketTypes")).isNull();
    }

    @Test
    public void serializesWithTicketTypesOnly() {
        BestAvailableForHolding bestAvailable = new BestAvailableForHolding()
                .setNumberForTicketType("vip", 4);

        String json = new Gson().toJson(bestAvailable);
        JsonObject parsed = JsonParser.parseString(json).getAsJsonObject();

        assertThat(parsed.get("number")).isNull();
        assertThat(parsed.getAsJsonObject("ticketTypes").get("vip").getAsInt()).isEqualTo(4);
    }
}
