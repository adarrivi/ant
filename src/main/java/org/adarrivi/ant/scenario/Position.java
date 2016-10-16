package org.adarrivi.ant.scenario;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position at(int x, int y) {
        return new Position(x, y);
    }

    public Position add(final Position position) {
        return at(x + position.x, y + position.y);
    }

    public Position subtract(final Position position) {
        return at(x - position.x, y - position.y);
    }

    public int distance(final Position position) {
        final Position subtract = this.subtract(position);
        return (int) Math.sqrt(subtract.x * subtract.x + subtract.y * subtract.y);
    }

    /**
     * @param direction direction to get the new position, in radians
     * @param distance  distance to the new position
     */
    public Position move(double direction, int distance) {
        int nextY = y + (int) (Math.sin(direction) * distance);
        int nextX = x + (int) (Math.cos(direction) * distance);
        return at(nextX, nextY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
