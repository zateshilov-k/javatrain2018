package com.epam.battleships.player;

import com.epam.battleships.inputcontroller.Action;
import com.epam.battleships.ship.Coordinate;
import com.epam.battleships.ship.Ship;
import com.epam.battleships.ship.ShipType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HumanPlayerTest {
    HumanPlayer player1 = new HumanPlayer(new Grid(), new Grid());
    HumanPlayer player2 = new HumanPlayer(new Grid(), new Grid());

    @Before
    public void initPlayer1() {
        player1.ships.clear();
        Ship testShip = new Ship(new Coordinate(0, 0), new Coordinate(1, 0), ShipType.DESTROYER);
        player1.ships.add(testShip);
    }

    @Test
    public void testPlaceShips() {
        Ship testShip = new Ship(new Coordinate(1, 0), new Coordinate(2, 0), ShipType.DESTROYER);

        Assert.assertTrue(player1.placeShips(Action.DOWN));
        Assert.assertEquals(testShip, player1.ships.get(0));

        Assert.assertTrue(player1.placeShips(Action.RIGHT));
        testShip.shiftY(1);
        Assert.assertEquals(testShip, player1.ships.get(0));

        Assert.assertTrue(player1.placeShips(Action.LEFT));
        testShip.shiftY(-1);
        Assert.assertEquals(testShip, player1.ships.get(0));

        Assert.assertTrue(player1.placeShips(Action.UP));
        testShip.shiftX(-1);
        Assert.assertEquals(testShip, player1.ships.get(0));

        Assert.assertFalse(player1.placeShips(Action.DO_ACTION));
        testShip.placeShip();
        Assert.assertEquals(testShip, player1.ships.get(0));
    }

    @Test
    public void testShoot() {
        // move shoot pointer to (0, 0)
        for (int i = 0; i < 5; ++i) {
            player2.shoot(Action.UP, player1);
            player2.shoot(Action.LEFT, player1);
        }
        // shoot at (0, 0)
        Assert.assertTrue(player2.shoot(Action.DO_ACTION, player1));
        player2.shoot(Action.DOWN, player1);
        // shoot at (1, 0)
        Assert.assertTrue(player2.shoot(Action.DO_ACTION, player1));
        //check, if we killed enemy ship
        Assert.assertTrue(player2.deadEnemyShips.contains(player1.ships.get(0)));
    }
}
