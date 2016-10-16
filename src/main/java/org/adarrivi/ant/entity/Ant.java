package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.Collection;

public class Ant implements ScenarioEntity {

    private final int size;
    private Position position;
    private double rotation;
    private AntState state;

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

    void act(final Collection<ScenarioEntity> accessibleEntities) {
        state.act(this, accessibleEntities);
    }

    void setState(AntState state) {
        this.state = state;
    }
}
