package io.seats.seatingChart;

import static org.assertj.core.api.Assertions.assertThat;
import static io.seats.utils.TestUtils.resource;

import org.junit.Test;

import io.seats.SeatsioJavascriptInterface;

public class TicketTypesPriceTest {

    @Test
    public void testDeserialize() {
        String json = resource("json/ticket-types-price.json");
        Price price = SeatsioJavascriptInterface.GSON.fromJson(json, Price.class);

        assertThat(price).isInstanceOf(TicketTypesPrice.class);

        TicketTypesPrice ticketTypesPrice = (TicketTypesPrice) price;
        assertThat(ticketTypesPrice.ticketTypes).hasSize(2);

        TicketTypePricing studentTicketType = ticketTypesPrice.ticketTypes.get(0);
        assertThat(studentTicketType.price).isEqualTo(29.5f);
        assertThat(studentTicketType.ticketType).isEqualTo("student");
        assertThat(studentTicketType.label).isEqualTo("Student");
        assertThat(studentTicketType.description).isEqualTo("Discounted for card-carrying students");
        assertThat(studentTicketType.primary).isTrue();
        assertThat(studentTicketType.originalPrice).isEqualTo(30.5f);
        assertThat(studentTicketType.fee).isEqualTo(0.5f);

        TicketTypePricing duckTicketType = ticketTypesPrice.ticketTypes.get(1);
        assertThat(duckTicketType.price).isEqualTo(25f);
        assertThat(duckTicketType.ticketType).isEqualTo("duck");
        assertThat(duckTicketType.label).isEqualTo("Duck");
        assertThat(duckTicketType.description).isEqualTo("Discounted for card-carrying ducks");
        assertThat(duckTicketType.primary).isFalse();
        assertThat(duckTicketType.originalPrice).isEqualTo(27.8f);
        assertThat(duckTicketType.fee).isEqualTo(0.8f);

    }
}
