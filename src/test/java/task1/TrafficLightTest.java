package test.java.task1;

import main.java.task1.TrafficLight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrafficLightTest {
    @Test
    public void colorWorksProperly() {
        assertEquals(TrafficLight.Color.RED, TrafficLight.getColorAfterTime(0));
        assertEquals(TrafficLight.Color.RED, TrafficLight.getColorAfterTime(1));

        assertEquals(TrafficLight.Color.YELLOW, TrafficLight.getColorAfterTime(2));
        assertEquals(TrafficLight.Color.YELLOW, TrafficLight.getColorAfterTime(3));
        assertEquals(TrafficLight.Color.YELLOW, TrafficLight.getColorAfterTime(4));

        assertEquals(TrafficLight.Color.GREEN, TrafficLight.getColorAfterTime(5));
        assertEquals(TrafficLight.Color.GREEN, TrafficLight.getColorAfterTime(9));

        assertEquals(TrafficLight.Color.RED, TrafficLight.getColorAfterTime(10));
        assertEquals(TrafficLight.Color.RED, TrafficLight.getColorAfterTime(11));

        assertEquals(TrafficLight.Color.YELLOW, TrafficLight.getColorAfterTime(12));
        assertEquals(TrafficLight.Color.YELLOW, TrafficLight.getColorAfterTime(13));
        assertEquals(TrafficLight.Color.YELLOW, TrafficLight.getColorAfterTime(14));
    }

    @Test
    public void minutesCantBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> TrafficLight.getColorAfterTime(-1));
    }
}
