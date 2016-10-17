package org.adarrivi.ant.entity;

import org.adarrivi.ant.entity.state.State;
import org.adarrivi.ant.random.RandomGenerator;
import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.Collection;

public class Ant implements ScenarioEntity {

    private static final double ROTATION_DELTA = 0.1;
    private static final int FORWARD_STEP_DISTANCE = 3;

    private final RandomGenerator randomGenerator;
    private final int size;
    private Position position;
    private double rotation;
    private State state;

    public Ant(RandomGenerator randomGenerator, int size) {
        this.randomGenerator = randomGenerator;
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

    public void moveRandomlyForward() {
        rotation += randomGenerator.randomBoolean() ? ROTATION_DELTA : -ROTATION_DELTA;
        position = position.move(rotation, FORWARD_STEP_DISTANCE);
    }

    void act(final Collection<ScenarioEntity> accessibleEntities) {
        state.act(this, accessibleEntities);
    }

    void setState(State state) {
        this.state = state;
    }
}
