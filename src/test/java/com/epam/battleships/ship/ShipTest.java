package com.epam.battleships.ship;

import org.junit.Assert;
import org.junit.Test;


public class ShipTest {
    Ship ship = new Ship(new Coordinate(0, 0), new Coordinate(0, 3), ShipType.BATTLESHIP);

    @Test
    public void testIsHit() {
        Assert.assertTrue(ship.isHit(new Coordinate(0, 0)));
        Assert.assertTrue(ship.isHit(new Coordinate(0, 1)));
        Assert.assertTrue(ship.isHit(new Coordinate(0, 2)));
        Assert.assertTrue(ship.isHit(new Coordinate(0, 3)));

        Assert.assertFalse(ship.isHit(new Coordinate(0, 4)));
        Assert.assertFalse(ship.isHit(new Coordinate(0, -1)));
    }

    @Test
    public void testIsOverlap() {
        Ship anotherShip = new Ship(new Coordinate(1, 1), new Coordinate(1, 1), ShipType.TORPEDO_BOAT);
        Assert.assertTrue(ship.isOverlap(anotherShip));

        anotherShip = new Ship(new Coordinate(-2, 0), new Coordinate(0, 0), ShipType.CRUISER);
        Assert.assertTrue(ship.isOverlap(anotherShip));

        anotherShip = new Ship(new Coordinate(2, 0), new Coordinate(2, 0), ShipType.TORPEDO_BOAT);
        Assert.assertFalse(ship.isOverlap(anotherShip));
    }
}
