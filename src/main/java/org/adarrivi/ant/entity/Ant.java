package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.Entity;
import org.adarrivi.ant.scenario.Position;

public class Ant implements Entity {

    private final int size;
    private Position position;

    public Ant(int size) {
        this.size = size;
    }


    @Override
    public int getRadius() {
        return size;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
