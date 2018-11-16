package main;

import player.AIPlayer;
import player.Grid;
import player.HumanPlayer;
import player.Player;
import inputcontroller.Action;
import inputcontroller.InputController;
import ship.ShipType;
import state.MenuState;

public class MainMenu {
    MenuState state = MenuState.VS_HUMAN;
    InputController inputController = new InputController();
    Game game;
    Grid player1OwnGrid = new Grid();
    Grid player1EnemyGrid = new Grid();
    Grid player2OwnGrid = new Grid();
    Grid player2EnemyGrid = new Grid();
    boolean exit = false;

    public void draw() {
        System.out.println("************************************");
        System.out.println();
        for (MenuState value : MenuState.values()) {
            if (value == state) {
                System.out.println("[*]  " + value.toString());
            } else {
                System.out.println("[ ]  " + value.toString());
            }
        }
        System.out.println();
        System.out.println("************************************");
    }

    public void changeState(Action action) {
        switch (action) {
            case DOWN:
                state = state.getNextState();
                break;
            case UP:
                state = state.getPreviousState();
                break;
            case DO_ACTION:
                switch (state) {
                    case VS_HUMAN: {
                        Player player1 = new HumanPlayer(player1OwnGrid, player1EnemyGrid);
                        Player player2 = new HumanPlayer(player2OwnGrid, player2EnemyGrid);
                        Game game = new Game(player1, player2);
                        game.run();
                        break;
                    }
                    case VS_AI: {
                        Player player1 = new HumanPlayer(player1OwnGrid, player1EnemyGrid);
                        Player player2 = new AIPlayer(player2OwnGrid, player2EnemyGrid);
                        game = new Game(player1, player2);
                        game.run();
                        break;
                    }
                    case HELP:
                        drawHelp();
                        break;
                    case EXIT:
                        exit = true;
                        break;
                }
        }
    }

    private void drawHelp() {
        System.out.println("Use 'w','a','s','d' to move ship or aim up, left, down, right respectively");
        System.out.println("Use 'q' to rotate ship and 'e' to place ship or to shoot at chosen position");
        System.out.println("Type exit if you want to quit");
        System.out.println("There is 4 types of Ships: ");
        for (ShipType value : ShipType.values()) {
            System.out.println(value.name() + " having " + value.getNumberShips()
                    + " number of ships with length " + (value.getShipLength() + 1));
        }

    }

    public void run() {
        while (!exit) {
            draw();
            inputController.nextAction();
            changeState(inputController.getCurrentAction());
        }
    }
}
