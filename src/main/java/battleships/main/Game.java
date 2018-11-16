package main;

import player.Player;
import state.GameState;

public class Game {
    Player playerOne;
    Player playerTwo;
    GameState state = GameState.PLAYER1_IS_PLACING_SHIPS;
    private boolean gameFinished = false;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void run() {
        while (!gameFinished) {
            switch (state) {
                case PLAYER1_IS_PLACING_SHIPS:
                    playerTwo.draw(playerOne);
                    System.out.println("Player 2 is placing ships");
                    state = playerTwo.placeShipsAndGetNewState(state);
                    break;
                case PLAYER2_IS_PLACING_SHIPS:
                    playerOne.draw(playerTwo);
                    System.out.println("Player 1 is placing ships");
                    state = playerOne.placeShipsAndGetNewState(state);
                    break;
                case PLAYER2_IS_ATTACKING:
                    playerOne.draw(playerTwo);
                    System.out.println("Player 1 is attacking");
                    state = playerOne.shootAndGetNewState(state, playerTwo);
                    checkWinCondition();
                    break;
                case PLAYER1_IS_ATTACKING:
                    playerTwo.draw(playerOne);
                    System.out.println("Player 2 is attacking");
                    state = playerTwo.shootAndGetNewState(state, playerOne);
                    checkWinCondition();
                    break;
            }
        }
    }

    private void checkWinCondition() {
        if (playerOne.getShipsSize() == playerTwo.getDeadEnemyShipsSize()) {
            System.out.println("Player 2 WIN!");
            gameFinished = true;
        } else if (playerTwo.getShipsSize() == playerOne.getDeadEnemyShipsSize()) {
            System.out.println("Player 1 WIN!");
            gameFinished = true;
        }
    }
}
