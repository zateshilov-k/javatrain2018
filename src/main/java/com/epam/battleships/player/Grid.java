package com.epam.battleships.player;

import com.epam.battleships.ship.Coordinate;
import com.epam.battleships.ship.Ship;
import com.epam.battleships.ship.Shoot;

import java.util.*;
import java.util.stream.Collectors;

public class Grid {
    private static int rowAndColumnNumber;

    static {
        String result = ResourceBundle.getBundle("settings").getString("gridSize");
        rowAndColumnNumber = Integer.parseInt(result);
    }

    public Coordinate shootPointer = new Coordinate(rowAndColumnNumber / 2, rowAndColumnNumber / 2);
    public String[][] cellsValues;

    public Grid() {
        cellsValues = new String[rowAndColumnNumber][rowAndColumnNumber];
        for (int i = 0; i < rowAndColumnNumber; ++i) {
            for (int j = 0; j < rowAndColumnNumber; ++j) {
                cellsValues[i][j] = " ";
            }
        }
    }


    public static int getRowAndColumnNumber() {
        return rowAndColumnNumber;
    }

    public static boolean isOutOfBounds(Coordinate coordinate) {
        return !((coordinate.x <= rowAndColumnNumber - 1) && (coordinate.x >= 0) &&
                (coordinate.y <= rowAndColumnNumber - 1) && (coordinate.y >= 0));
    }

    public void draw() {
        drawFirstLine();
        for (int i = 0; i < rowAndColumnNumber; i++) {
            for (int j = 0; j < rowAndColumnNumber; j++) {
                String currentSymbol = cellsValues[i][j];
                if (j == 0) {
                    if (i == rowAndColumnNumber - 1) {
                        System.out.print((i) + " | " + currentSymbol + " | ");
                    } else {
                        System.out.print((i) + " | " + currentSymbol + " | ");
                    }
                } else {
                    System.out.print(currentSymbol + " | ");
                }
            }
            System.out.println();
        }
    }

    private void drawFirstLine() {
        StringBuilder firstLine = new StringBuilder();
        firstLine.append("    ");
        for (int currentChar = 0; currentChar <= 9; ++currentChar) {
            firstLine.append(currentChar);
            firstLine.append("   ");
        }
        System.out.println(firstLine.toString());
    }

    public void clearCells() {
        for (String[] cellsValue : cellsValues) {
            for (int i = 0; i < cellsValue.length; ++i) {
                cellsValue[i] = " ";
            }
        }
    }

    public void useHumanPlayerShips(List<Ship> ships) {
        clearCells();
        Optional<Ship> ship = ships.stream().filter(currShip -> !currShip.isPlaced()).findFirst();
        if (!ship.isPresent()) {
            useShips(ships);
        } else {
            ArrayList<Ship> currentShips = ships.stream()
                    .filter(s -> s.isPlaced()).collect(Collectors.toCollection(ArrayList::new));
            currentShips.add(ship.get());
            useShips(currentShips);
        }
    }

    public void draw(Set<Ship> deadShips, ArrayList<Shoot> shoots) {
        clearCells();
        useShoots(shoots);
        useShips(deadShips);
        usePointer();
        draw();
    }

    public void draw(List<Ship> ships, ArrayList<Shoot> shoots) {
        useHumanPlayerShips(ships);
        useShoots(shoots);
        draw();
    }

    private void usePointer() {
        if (!Grid.isOutOfBounds(shootPointer)) {
            cellsValues[shootPointer.x][shootPointer.y] = "*";
        }
    }

    public void useShoots(ArrayList<Shoot> shoots) {
        for (Shoot shoot : shoots) {
            if (!Grid.isOutOfBounds(shoot)) {
                cellsValues[shoot.x][shoot.y] = shoot.isHit ? "X" : "-";
            }
        }
    }

    private void useShips(Collection<Ship> ships) {
        for (Ship deadShip : ships) {
            for (Coordinate coordinate : deadShip.getShipCoordinates()) {
                if (!isOutOfBounds(coordinate)) {
                    cellsValues[coordinate.x][coordinate.y] = deadShip.getType().toString();
                }
            }
        }
    }

}


