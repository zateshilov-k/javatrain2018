package com.epam.battleships.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class TestShipCoordinates {
    ShipCoordinates shipCoordinates;

    @Before
    public void initShipCoordinates() {
        shipCoordinates = new ShipCoordinates(new Coordinate(1, 1), new Coordinate(1, 3));
    }

    @Test
    public void testShipCoordinatesCreation() {
        Assert.assertEquals(false, shipCoordinates.isParallelX());
        Assert.assertEquals(2, shipCoordinates.getLength());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShipCoordinatesCreationThrow() {
        new ShipCoordinates(new Coordinate(2, 1), new Coordinate(1, 3));
    }

    @Test
    public void testShipCoordinatesSpin() {
        ShipCoordinates spinnedCoordinates = new ShipCoordinates(new Coordinate(1, 1), new Coordinate(3, 1));
        shipCoordinates.spin();
        Assert.assertEquals(spinnedCoordinates, shipCoordinates);
        Assert.assertTrue(spinnedCoordinates.isParallelX());
    }

    @Test
    public void testShipCoordinatesShift() {
        ShipCoordinates shiftedCoordinates = new ShipCoordinates(new Coordinate(2, 2), new Coordinate(2, 4));
        shipCoordinates.shiftX(1);
        shipCoordinates.shiftY(1);
        Assert.assertEquals(shiftedCoordinates, shipCoordinates);
    }

    @Test
    public void testShipCoordinatesIterator() {
        Iterator<Coordinate> iterator = shipCoordinates.iterator();
        Coordinate coordinateIterator1 = new Coordinate(1, 1);
        Coordinate coordinateIterator2 = new Coordinate(1, 2);
        Coordinate coordinateIterator3 = new Coordinate(1, 3);
        Assert.assertEquals(coordinateIterator1, iterator.next());
        Assert.assertEquals(coordinateIterator2, iterator.next());
        Assert.assertEquals(coordinateIterator3, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testShipCoordinatesEquals() {
        ShipCoordinates anotherShipCoordinates = new ShipCoordinates(
                new Coordinate(1, 1),
                new Coordinate(1, 3)
        );
        Assert.assertEquals(anotherShipCoordinates, shipCoordinates);
        Assert.assertEquals(anotherShipCoordinates.hashCode(), shipCoordinates.hashCode());
    }
}

