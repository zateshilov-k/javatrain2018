package test.java;

import main.java.task1.TrafficLight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrafficLightTest {
    @Test
    public void colorWorksProperly() {
        Assertions.assertEquals("red", TrafficLight.getColorAfterTime(0));
        assertEquals("red", TrafficLight.getColorAfterTime(1));

        assertEquals("yellow", TrafficLight.getColorAfterTime(2));
        assertEquals("yellow", TrafficLight.getColorAfterTime(3));
        assertEquals("yellow", TrafficLight.getColorAfterTime(4));

        assertEquals("green", TrafficLight.getColorAfterTime(5));
        assertEquals("green", TrafficLight.getColorAfterTime(9));

        assertEquals("red", TrafficLight.getColorAfterTime(10));
        assertEquals("red", TrafficLight.getColorAfterTime(11));

        assertEquals("yellow", TrafficLight.getColorAfterTime(12));
        assertEquals("yellow", TrafficLight.getColorAfterTime(13));
        assertEquals("yellow", TrafficLight.getColorAfterTime(14));
    }

    @Test
    public void minutesCantBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> TrafficLight.getColorAfterTime(-1));
    }
}
