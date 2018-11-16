package player;

import inputcontroller.Action;
import inputcontroller.InputController;
import ship.Coordinate;
import ship.Ship;
import ship.ShipType;
import state.GameState;

import java.util.Optional;

public class HumanPlayer extends Player {

    InputController inputController = new InputController();
    public HumanPlayer(Grid ownGrid, Grid enemyGrid) {
        super(ownGrid, enemyGrid);
        for (ShipType currentShipType : ShipType.values()) {
            for (int i = 0; i < currentShipType.getNumberShips(); ++i) {
                ships.add(new Ship(
                        new Coordinate(
                                Grid.getRowAndColumnNumber() / 3,
                                Grid.getRowAndColumnNumber() / 3),
                        new Coordinate(
                                Grid.getRowAndColumnNumber() / 3 + currentShipType.getShipLength(),
                                Grid.getRowAndColumnNumber() / 3),
                        currentShipType));
            }
        }
    }

    @Override
    public GameState placeShipsAndGetNewState(GameState state) {
        inputController.nextAction();
        if (!placeShips(inputController.getCurrentAction())) {
            return state.getNextState();
        } else {
            return state;
        }

    }

    @Override
    public GameState shootAndGetNewState(GameState state, Player anotherPlayer) {
        inputController.nextAction();
        if (!shoot(inputController.getCurrentAction(), anotherPlayer)) {
            return state.getNextState();
        } else {
            return state;
        }
    }

    @Override
    public void draw(Player anotherPlayer) {
        enemyGrid.draw(deadEnemyShips, shoots);
        ownGrid.draw(ships, anotherPlayer.shoots);
    }

    public boolean placeShips(Action currentAction) {
        Optional<Ship> ship = ships.stream().filter(currShip -> !currShip.isPlaced()).findFirst();
        if (!ship.isPresent()) {
            return false;
        } else {
            Ship currentShip = ship.get();
            switch (currentAction) {
                case RIGHT:
                    currentShip.shiftY(1);
                    break;
                case LEFT:
                    currentShip.shiftY(-1);
                    break;
                case UP:
                    currentShip.shiftX(-1);
                    break;
                case DOWN:
                    currentShip.shiftX(1);
                    break;
                case SPIN_SHIP:
                    currentShip.spin();
                    break;
                case DO_ACTION:
                    if (isCorrectlyPlaced(currentShip)) {
                        currentShip.placeShip();
                    } else {
                        System.out.println("Wrong ship position");
                    }
                    break;
                case EXIT:
                    System.exit(0);
            }
            Optional<Ship> requiredShip = ships.stream().filter(currShip -> !currShip.isPlaced()).findFirst();
            if (requiredShip.isPresent()) {
                return true;
            } else {
                return false;
            }

        }
    }

    public boolean shoot(Action currentAction, Player anotherPlayer) {
        switch (currentAction) {
            case RIGHT:
                enemyGrid.shootPointer = enemyGrid.shootPointer.plusY(1);
                break;
            case LEFT:
                enemyGrid.shootPointer = enemyGrid.shootPointer.plusY(-1);
                break;
            case UP:
                enemyGrid.shootPointer = enemyGrid.shootPointer.plusX(-1);
                break;
            case DOWN:
                enemyGrid.shootPointer = enemyGrid.shootPointer.plusX(1);
                break;
            case DO_ACTION:
                if (!Grid.isOutOfBounds(enemyGrid.shootPointer) && !isAlreadyShootHere(enemyGrid.shootPointer)) {
                    return shootAtPosition(anotherPlayer, enemyGrid.shootPointer);
                } else {
                    System.out.println("Wrong shoot position");
                }
                break;
        }
        return true;
    }

}