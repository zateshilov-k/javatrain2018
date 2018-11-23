package com.epam.battleships.ship;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {
    @Test
    public void testIsAround() {
        Coordinate coordinate = new Coordinate(1, 1);
        Assert.assertTrue(coordinate.isAround(new Coordinate(0, 0)));
        Assert.assertTrue(coordinate.isAround(new Coordinate(0, 1)));
        Assert.assertTrue(coordinate.isAround(new Coordinate(1, 0)));
        Assert.assertTrue(coordinate.isAround(new Coordinate(1, 1)));
        Assert.assertTrue(coordinate.isAround(new Coordinate(2, 0)));
        Assert.assertTrue(coordinate.isAround(new Coordinate(0, 2)));
        Assert.assertTrue(coordinate.isAround(new Coordinate(1, 2)));
        Assert.assertTrue(coordinate.isAround(new Coordinate(2, 1)));
        Assert.assertTrue(coordinate.isAround(new Coordinate(2, 2)));
    }

    @Test
    public void testIsNotAround() {
        Coordinate coordinate = new Coordinate(1, 1);
        Assert.assertFalse(coordinate.isAround(new Coordinate(3, 0)));
        Assert.assertFalse(coordinate.isAround(new Coordinate(3, 1)));
        Assert.assertFalse(coordinate.isAround(new Coordinate(3, 2)));
        Assert.assertFalse(coordinate.isAround(new Coordinate(3, 3)));
        Assert.assertFalse(coordinate.isAround(new Coordinate(2, 3)));
        Assert.assertFalse(coordinate.isAround(new Coordinate(1, 3)));
        Assert.assertFalse(coordinate.isAround(new Coordinate(0, 3)));
    }

    @Test
    public void testPlus() {
        Coordinate coordinate = new Coordinate(0, 0);
        Assert.assertEquals(new Coordinate(1, 0), coordinate.plusX(1));
        Assert.assertEquals(new Coordinate(-1, 0), coordinate.plusX(-1));
        Assert.assertEquals(new Coordinate(0, 1), coordinate.plusY(1));
        Assert.assertEquals(new Coordinate(0, -1), coordinate.plusY(-1));
    }

    @Test
    public void testEquals() {
        Coordinate coordinate1 = new Coordinate(1, 1);
        Coordinate coordinate2 = new Coordinate(1, 1);
        Assert.assertTrue(coordinate1.equals(coordinate2));
        Assert.assertEquals(coordinate1.hashCode(), coordinate2.hashCode());
    }
}
