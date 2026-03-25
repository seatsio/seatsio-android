package io.seats.seatingChart;

import static org.assertj.core.api.Assertions.assertThat;
import static io.seats.utils.TestUtils.resource;

import org.junit.Test;

import io.seats.SeatsioJavascriptInterface;

public class SeatsioObjectTest {

    @Test
    public void deserializesWheelchairSpaceType() {
        String json = resource("json/seatsio-object-with-wheelchair-space-type.json");
        SeatsioObject object = SeatsioJavascriptInterface.GSON.fromJson(json, SeatsioObject.class);

        assertThat(object.wheelchairSpaceType).isEqualTo(WheelchairSpaceType.WHEELCHAIR_ACCESSIBLE_SEAT);
    }

    @Test
    public void wheelchairSpaceTypeIsNullWhenAbsent() {
        String json = "{\"id\": \"A-1\", \"label\": \"A-1\", \"objectType\": \"seat\", \"labels\": {\"own\": \"1\", \"parent\": \"A\"}}";
        SeatsioObject object = SeatsioJavascriptInterface.GSON.fromJson(json, SeatsioObject.class);

        assertThat(object.wheelchairSpaceType).isNull();
    }
}
