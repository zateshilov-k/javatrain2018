package ship;

import java.util.Iterator;
import java.util.Objects;

public class ShipCoordinates implements Iterable<Coordinate> {
    Coordinate startCoordinate;
    Coordinate endCoordinate;
    int length;
    boolean isParallelX;

    public ShipCoordinates(Coordinate startCoordinate, Coordinate endCoordinate) {
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        if (startCoordinate.x == endCoordinate.x) {
            isParallelX = false;
            length = endCoordinate.y - startCoordinate.y;
        } else if (startCoordinate.y == endCoordinate.y) {
            isParallelX = true;
            length = endCoordinate.x - startCoordinate.x;
        } else {
            throw new IllegalArgumentException("Wrong ship coordinates");
        }
    }

    public int getLength() {
        return length;
    }

    public boolean isParallelX() {
        return isParallelX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipCoordinates that = (ShipCoordinates) o;
        return length == that.length &&
                isParallelX == that.isParallelX &&
                startCoordinate.equals(that.startCoordinate) &&
                endCoordinate.equals(that.endCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startCoordinate, endCoordinate, length, isParallelX);
    }

    @Override
    public String toString() {
        return "ShipCoordinates{" +
                "startCoordinate=" + startCoordinate +
                ", endCoordinate=" + endCoordinate +
                '}';
    }

    @Override
    public Iterator<Coordinate> iterator() {
        Iterator<Coordinate> it = new Iterator<Coordinate>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex <= length;
            }

            @Override
            public Coordinate next() {
                return isParallelX ? new Coordinate(startCoordinate.x + currentIndex++, startCoordinate.y) :
                        new Coordinate(startCoordinate.x, startCoordinate.y + currentIndex++);
            }
        };
        return it;
    }

    public void shiftX(int value) {
        startCoordinate.x += value;
        endCoordinate.x += value;
    }

    public void shiftY(int value) {
        startCoordinate.y += value;
        endCoordinate.y += value;
    }

    public void spin() {
        if (startCoordinate.y == endCoordinate.y) {
            endCoordinate.y = startCoordinate.y + endCoordinate.x - startCoordinate.x;
            endCoordinate.x = startCoordinate.x;
            isParallelX = false;
        } else if (startCoordinate.x == endCoordinate.x) {
            endCoordinate.x = startCoordinate.x + endCoordinate.y - startCoordinate.y;
            endCoordinate.y = startCoordinate.y;
            isParallelX = true;
        }
    }
}
