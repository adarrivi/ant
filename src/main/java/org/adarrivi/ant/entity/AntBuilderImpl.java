package org.adarrivi.ant.entity;

import org.adarrivi.ant.entity.state.State;
import org.adarrivi.ant.random.RandomGenerator;
import org.adarrivi.ant.scenario.Position;

class AntBuilderImpl implements AntBuilder {

    private Position position;
    private double rotation = 0;
    private RandomGenerator randomGenerator;
    private State initialState;

    @Override
    public AntBuilder at(Position position) {
        this.position = position;
        return this;
    }

    @Override
    public AntBuilder withRotation(double rotation) {
        this.rotation = rotation;
        return this;
    }

    @Override
    public AntBuilder withRandomness(RandomGenerator randomness) {
        this.randomGenerator = randomness;
        return this;
    }

    @Override
    public AntBuilder withInitialState(State state) {
        this.initialState = state;
        return this;
    }

    @Override
    public Ant build() {
        return new Ant(position, rotation, initialState, randomGenerator);
    }
}
