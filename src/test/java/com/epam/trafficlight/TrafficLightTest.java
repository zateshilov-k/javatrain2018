package com.epam.trafficlight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TrafficLightTest {
    @Test
    public void testColor() {
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

    @Test(expected = IllegalArgumentException.class)
    public void minutesCantBeNegative() {
        TrafficLight.getColorAfterTime(-1);
    }
}
