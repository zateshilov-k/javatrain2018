package com.epam.battleships.player;


import com.epam.battleships.ship.Coordinate;
import com.epam.battleships.ship.Ship;
import com.epam.battleships.ship.ShipType;
import com.epam.battleships.state.GameState;

public class AIPlayer extends Player {
    public AIPlayer(Grid ownGrid, Grid enemyGrid) {
        super(ownGrid, enemyGrid);
    }

    @Override
    public GameState placeShipsAndGetNewState(GameState state) {
        placeShips();
        return state.getNextState();
    }

    @Override
    public GameState shootAndGetNewState(GameState state, Player anotherPlayer) {
        if (!shoot(anotherPlayer)) {
            return state.getNextState();
        } else {
            return state;
        }
    }

    @Override
    public void draw(Player anotherPlayer) {
        anotherPlayer.draw(this);
    }

    public void placeShips() {
        for (ShipType currentShipType : ShipType.values()) {
            for (int currentShipIdx = 0; currentShipIdx < currentShipType.getNumberShips(); ++currentShipIdx) {
                while (true) {
                    Coordinate coordinate = Coordinate.nextRandomCoordinate();
                    Ship shipParallelY = new Ship(coordinate,
                            coordinate.plusY(currentShipType.getShipLength()),
                            currentShipType);
                    boolean isPlacedY = isCorrectlyPlaced(shipParallelY);
                    if (isPlacedY) {
                        shipParallelY.placeShip();
                        ships.add(shipParallelY);
                        break;
                    }
                    Ship shipParallelX = new Ship(coordinate,
                            coordinate.plusX(currentShipType.getShipLength()),
                            currentShipType);
                    boolean isPlacedX = isCorrectlyPlaced(shipParallelX);
                    if (isPlacedX) {
                        shipParallelX.placeShip();
                        ships.add(shipParallelX);
                        break;
                    }
                }
            }
        }
    }


    public boolean shoot(Player anotherPlayer) {
        Coordinate shootAt = Coordinate.nextRandomCoordinate();
        while (isAlreadyShootHere(shootAt)) {
            shootAt = Coordinate.nextRandomCoordinate();
        }
        return shootAtPosition(anotherPlayer, shootAt);
    }
}
