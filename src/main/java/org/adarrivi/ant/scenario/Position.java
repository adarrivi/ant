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
        return new Position(x + position.x, y + position.y);
    }

    public Position substract(final Position position) {
        return new Position(x - position.x, y - position.y);
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
}
