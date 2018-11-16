package player;

import ship.Coordinate;
import ship.Ship;
import ship.Shoot;
import state.GameState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Player {
    protected List<Ship> ships = new ArrayList<>();
    protected Grid ownGrid;
    protected Grid enemyGrid;
    protected ArrayList<Shoot> shoots = new ArrayList<>();
    protected Set<Ship> deadEnemyShips = new HashSet<>();

    public Player(Grid ownGrid, Grid enemyGrid) {
        this.ownGrid = ownGrid;
        this.enemyGrid = enemyGrid;
    }

    public int getShipsSize() {
        return ships.size();
    }
    public int getDeadEnemyShipsSize() {
        return deadEnemyShips.size();
    }
    protected boolean isCorrectlyPlaced(Ship currentShip) {
        if (Grid.isOutOfBounds(currentShip.getStartCoordinate())
                || Grid.isOutOfBounds(currentShip.getEndCoordinate())) {
            return false;
        } else if (isOverlapOtherShips(currentShip)) {
            return false;
        }
        return true;
    }

    protected boolean isOverlapOtherShips(Ship ship) {
        for (Ship currentShip : ships) {
            if (!currentShip.isPlaced()) {
                continue;
            }
            if (currentShip.isOverlap(ship)) {
                return true;
            }
        }
        return false;
    }

    public boolean hitShips(Coordinate shoot) {
        for (Ship ship : ships) {
            if (ship.isHit(shoot)) {
                ship.decreaseLives();
                return true;
            }
        }
        return false;
    }

    public boolean shootAtPosition(Player anotherPlayer, Coordinate shoot) {
        if (anotherPlayer.hitShips(shoot)) {
            shoots.add(new Shoot(shoot.x, shoot.y, true));
            deadEnemyShips.addAll(
                    anotherPlayer.ships
                            .stream()
                            .filter(s -> s.getNumberOfLives() == 0)
                            .collect(Collectors.toSet())
            );
            return true;
        } else {
            shoots.add(new Shoot(shoot.x, shoot.y, false));
            return false;
        }
    }

    protected boolean isAlreadyShootHere(Coordinate shootPointer) {
        for (Shoot shoot : shoots) {
            if (shoot.x == shootPointer.x && shoot.y == shootPointer.y) {
                return true;
            }
        }
        return false;
    }

    public abstract GameState placeShipsAndGetNewState(GameState state);

    public abstract GameState shootAndGetNewState(GameState state, Player anotherPlayer);

    public abstract void draw(Player anotherPlayer);
}
