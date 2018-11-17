package com.epam.battleships.player;

import com.epam.battleships.ship.Coordinate;
import com.epam.battleships.ship.Ship;
import com.epam.battleships.ship.ShipType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestPlayer {
    static Player player1 = new HumanPlayer(new Grid(), new Grid());
    static Player player2 = new HumanPlayer(new Grid(), new Grid());

    /**
     * Ship placement
     * 0123456 y-axis
     * 0 BBBB
     * 1
     * 2   T
     * 3
     * x-axis
     */
    @Before
    public void initPlayer() {
        player1.ships.clear();
        Ship ship1 = new Ship(new Coordinate(0, 0), new Coordinate(0, 3), ShipType.BATTLESHIP);
        ship1.placeShip();
        Ship ship2 = new Ship(new Coordinate(2, 2), new Coordinate(2, 2), ShipType.TORPEDO_BOAT);
        ship2.placeShip();
        player1.ships.add(ship1);
        player1.ships.add(ship2);
    }

    @Test
    public void testIsCorrectlyPlaced() {
        Ship testShip = new Ship(new Coordinate(1, 0), new Coordinate(1, 3), ShipType.BATTLESHIP);
        Assert.assertFalse(player1.isCorrectlyPlaced(testShip));

        testShip.shiftX(3);
        Assert.assertTrue(player1.isCorrectlyPlaced(testShip));

        Ship shipOutsideGrid = new Ship(new Coordinate(10, 0), new Coordinate(10, 3), ShipType.BATTLESHIP);
        Assert.assertFalse(player1.isCorrectlyPlaced(shipOutsideGrid));
    }

    @Test
    public void testIsOverlapOtherShips() {
        Ship testShip = new Ship(new Coordinate(1, 2), new Coordinate(1, 2), ShipType.TORPEDO_BOAT);
        Assert.assertTrue(player1.isOverlapOtherShips(testShip));

        testShip = new Ship(new Coordinate(1, 4), new Coordinate(1, 4), ShipType.TORPEDO_BOAT);
        Assert.assertTrue(player1.isOverlapOtherShips(testShip));

        testShip = new Ship(new Coordinate(0, 5), new Coordinate(0, 5), ShipType.TORPEDO_BOAT);
        Assert.assertFalse(player1.isOverlapOtherShips(testShip));
    }

    @Test
    public void testHitShips() {
        Coordinate aim = new Coordinate(0, 0);
        Assert.assertTrue(player1.hitShips(aim));
        Assert.assertEquals(3, player1.ships.get(0).getNumberOfLives());

        aim = new Coordinate(0, 1);
        Assert.assertTrue(player1.hitShips(aim));
        Assert.assertEquals(2, player1.ships.get(0).getNumberOfLives());

        aim = new Coordinate(0, 2);
        Assert.assertTrue(player1.hitShips(aim));
        Assert.assertEquals(1, player1.ships.get(0).getNumberOfLives());

        aim = new Coordinate(0, 3);
        Assert.assertTrue(player1.hitShips(aim));
        Assert.assertEquals(0, player1.ships.get(0).getNumberOfLives());

        aim = new Coordinate(2, 2);
        Assert.assertTrue(player1.hitShips(aim));
        Assert.assertEquals(0, player1.ships.get(0).getNumberOfLives());
    }

    @Test
    public void testShootAtPosition() {
        Assert.assertTrue(player2.shootAtPosition(player1, new Coordinate(0, 0)));
        Assert.assertTrue(player2.shootAtPosition(player1, new Coordinate(0, 1)));
        Assert.assertTrue(player2.shootAtPosition(player1, new Coordinate(0, 2)));
        Assert.assertTrue(player2.shootAtPosition(player1, new Coordinate(0, 3)));
        Assert.assertTrue(player2.deadEnemyShips.contains(player1.ships.get(0)));
        Assert.assertTrue(player2.shootAtPosition(player1, new Coordinate(2, 2)));
        Assert.assertTrue(player2.deadEnemyShips.contains(player1.ships.get(1)));

        Assert.assertFalse(player2.shootAtPosition(player1, new Coordinate(2, 1)));
        Assert.assertFalse(player2.shootAtPosition(player1, new Coordinate(1, 2)));
    }

    @Test
    public void testIsAlreadyShootHere() {
        player2.shoots.clear();
        player2.shootAtPosition(player1, new Coordinate(1, 1));
        Assert.assertTrue(player2.isAlreadyShootHere(new Coordinate(1, 1)));

        Assert.assertFalse(player2.isAlreadyShootHere(new Coordinate(1, 0)));
        Assert.assertFalse(player2.isAlreadyShootHere(new Coordinate(0, 1)));
    }
}
