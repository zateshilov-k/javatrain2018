package com.epam.battleships.player;

import com.epam.battleships.ship.Ship;
import com.epam.battleships.state.GameState;
import org.junit.Assert;
import org.junit.Test;


public class TestAIPlayer {
    AIPlayer player1 = new AIPlayer(new Grid(), new Grid());
    Player player2 = new AIPlayer(new Grid(), new Grid());

    @Test
    public void testPlaceShips() {
        player1.placeShips();
        for (Ship outShip : player1.ships) {
            for (Ship innerShip : player1.ships) {
                if (outShip != innerShip && innerShip.isOverlap(outShip)) {
                    Assert.assertTrue(false);
                }
            }
        }
    }

    @Test
    public void testPlaceShipsAndGetNewState() {
        Assert.assertEquals(GameState.PLAYER2_IS_PLACING_SHIPS,
                player1.placeShipsAndGetNewState(GameState.PLAYER1_IS_PLACING_SHIPS));
    }

    @Test
    public void testShootAndGetNewState() {
        Assert.assertEquals(GameState.PLAYER2_IS_ATTACKING,
                player1.shootAndGetNewState(GameState.PLAYER1_IS_ATTACKING, player2));
        Assert.assertEquals(GameState.PLAYER1_IS_ATTACKING,
                player1.shootAndGetNewState(GameState.PLAYER2_IS_ATTACKING, player2));
    }
}
