package ship;

import java.util.Iterator;
import java.util.Objects;

public class Ship {
    ShipCoordinates shipCoordinates;
    private boolean isPlaced = false;
    private int numberOfLives;
    private ShipType type;
    public Ship(Coordinate startCoordinates, Coordinate endCoordinate, ShipType type) {
        numberOfLives = type.getShipLength() + 1;
        this.shipCoordinates = new ShipCoordinates(startCoordinates, endCoordinate);
        this.type = type;
    }

    public ShipCoordinates getShipCoordinates() {
        return shipCoordinates;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public ShipType getType() {
        return type;
    }

    public void decreaseLives() {
        numberOfLives--;
    }

    public void placeShip() {
        isPlaced = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return isPlaced == ship.isPlaced &&
                numberOfLives == ship.numberOfLives &&
                shipCoordinates.equals(ship.shipCoordinates) &&
                type == ship.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipCoordinates, isPlaced, type, numberOfLives);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipCoordinates=" + shipCoordinates +
                ", type=" + type +
                '}';
    }

    public Coordinate getStartCoordinate() {
        return shipCoordinates.startCoordinate;
    }

    public Coordinate getEndCoordinate() {
        return shipCoordinates.endCoordinate;
    }

    public boolean isOverlap(Ship otherShip) {
        Iterator<Coordinate> iteratorCurrentShip = this.shipCoordinates.iterator();
        while (iteratorCurrentShip.hasNext()) {
            Coordinate coordinateCurrentShip = iteratorCurrentShip.next();
            Iterator<Coordinate> iteratorOtherShip = otherShip.shipCoordinates.iterator();
            while (iteratorOtherShip.hasNext()) {
                Coordinate coordinateOtherShip = iteratorOtherShip.next();
                if (coordinateCurrentShip.isAround(coordinateOtherShip)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void shiftY(int value) {
        this.shipCoordinates.shiftY(value);
    }

    public void shiftX(int value) {
        this.shipCoordinates.shiftX(value);
    }

    public void spin() {
        this.shipCoordinates.spin();
    }

    public boolean isHit(Coordinate shoot) {
        for (Coordinate shipCoordinate : this.shipCoordinates) {
            if (shipCoordinate.x == shoot.x && shipCoordinate.y == shoot.y) {
                return true;
            }
        }
        return false;
    }
}

