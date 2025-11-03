package io.seats.seatingChart;

import static org.assertj.core.api.Assertions.assertThat;
import static io.seats.utils.TestUtils.resource;

import org.junit.Test;

import io.seats.SeatsioJavascriptInterface;

public class ObjectPriceTest {

    @Test
    public void testDeserialize() {
        String json = resource("json/object-price.json");
        Price price = SeatsioJavascriptInterface.GSON.fromJson(json, Price.class);

        assertThat(price).isInstanceOf(ObjectPrice.class);

        ObjectPrice objectPrice = (ObjectPrice)price;
        assertThat(objectPrice.price).isEqualTo(30.5f);
        assertThat(objectPrice.originalPrice).isEqualTo(42.7f);
        assertThat(objectPrice.objects).hasSize(3);
        assertThat(objectPrice.objects).containsOnly("A-1", "B-2", "C-3");
        assertThat(objectPrice.fee).isEqualTo(2.5f);
        assertThat(objectPrice.ticketTypes).hasSize(2);

        TicketTypePricing studentTicketType = objectPrice.ticketTypes.get(0);
        assertThat(studentTicketType.price).isEqualTo(29.5f);
        assertThat(studentTicketType.ticketType).isEqualTo("student");
        assertThat(studentTicketType.label).isEqualTo("Student");
        assertThat(studentTicketType.description).isEqualTo("Discounted for card-carrying students");
        assertThat(studentTicketType.primary).isTrue();
        assertThat(studentTicketType.originalPrice).isEqualTo(30.5f);
        assertThat(studentTicketType.fee).isEqualTo(0.5f);

        TicketTypePricing duckTicketType = objectPrice.ticketTypes.get(1);
        assertThat(duckTicketType.price).isEqualTo(25f);
        assertThat(duckTicketType.ticketType).isEqualTo("duck");
        assertThat(duckTicketType.label).isEqualTo("Duck");
        assertThat(duckTicketType.description).isEqualTo("Discounted for card-carrying ducks");
        assertThat(duckTicketType.primary).isFalse();
        assertThat(duckTicketType.originalPrice).isEqualTo(27.8f);
        assertThat(duckTicketType.fee).isEqualTo(0.8f);
    }
}