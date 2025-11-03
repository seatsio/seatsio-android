package io.seats.seatingChart;

import static org.assertj.core.api.Assertions.assertThat;
import static io.seats.utils.TestUtils.resource;

import org.junit.Test;

import io.seats.SeatsioJavascriptInterface;

public class ChannelPriceTest {

    @Test
    public void testDeserialize() {
        String json = resource("json/channel-price.json");
        Price price = SeatsioJavascriptInterface.GSON.fromJson(json, Price.class);

        assertThat(price).isInstanceOf(ChannelPrice.class);

        ChannelPrice channelPrice = (ChannelPrice)price;
        assertThat(channelPrice.price).isEqualTo(30.5f);
        assertThat(channelPrice.originalPrice).isEqualTo(35f);
        assertThat(channelPrice.fee).isEqualTo(1.7f);
        assertThat(channelPrice.channels).hasSize(2);

        ChannelPricing channelA = channelPrice.channels.get(0);
        assertThat(channelA.channel).isEqualTo("Channel A");
        assertThat(channelA.price).isEqualTo(40.3f);
        assertThat(channelA.originalPrice).isEqualTo(42f);
        assertThat(channelA.fee).isEqualTo(2.5f);
        assertThat(channelA.ticketTypes).isNull();

        ChannelPricing channelB = channelPrice.channels.get(1);
        assertThat(channelB.channel).isEqualTo("Channel B");
        assertThat(channelB.price).isEqualTo(48.1f);
        assertThat(channelB.originalPrice).isEqualTo(50f);
        assertThat(channelB.fee).isEqualTo(3f);
        assertThat(channelB.ticketTypes).hasSize(2);

        TicketTypePricing studentTicketType = channelB.ticketTypes.get(0);
        assertThat(studentTicketType.price).isEqualTo(29.5f);
        assertThat(studentTicketType.ticketType).isEqualTo("student");
        assertThat(studentTicketType.label).isEqualTo("Student");
        assertThat(studentTicketType.description).isEqualTo("Discounted for card-carrying students");
        assertThat(studentTicketType.primary).isTrue();
        assertThat(studentTicketType.originalPrice).isEqualTo(30.5f);
        assertThat(studentTicketType.fee).isEqualTo(0.5f);

        TicketTypePricing duckTicketType = channelB.ticketTypes.get(1);
        assertThat(duckTicketType.price).isEqualTo(25f);
        assertThat(duckTicketType.ticketType).isEqualTo("duck");
        assertThat(duckTicketType.label).isEqualTo("Duck");
        assertThat(duckTicketType.description).isEqualTo("Discounted for card-carrying ducks");
        assertThat(duckTicketType.primary).isFalse();
        assertThat(duckTicketType.originalPrice).isEqualTo(27.8f);
        assertThat(duckTicketType.fee).isEqualTo(0.8f);


    }
}
