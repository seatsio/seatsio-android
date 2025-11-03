package io.seats.seatingChart;

import static org.assertj.core.api.Assertions.assertThat;
import static io.seats.utils.TestUtils.resource;

import org.junit.Test;

import io.seats.SeatsioJavascriptInterface;

public class SimplePriceTest {

    @Test
    public void testDeserialize() {
        String json = resource("json/simple-price.json");
        Price price = SeatsioJavascriptInterface.GSON.fromJson(json, Price.class);

        assertThat(price).isInstanceOf(SimplePrice.class);

        SimplePrice simplePrice = (SimplePrice)price;
        assertThat(simplePrice.price).isEqualTo(30.5f);
        assertThat(simplePrice.originalPrice).isEqualTo(35f);
        assertThat(simplePrice.fee).isEqualTo(1.7f);
    }
}