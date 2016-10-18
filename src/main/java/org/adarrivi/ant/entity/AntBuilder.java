package org.adarrivi.ant.entity;

import org.adarrivi.ant.entity.state.State;
import org.adarrivi.ant.random.RandomGenerator;
import org.adarrivi.ant.scenario.Position;

public interface AntBuilder extends Builder<Ant> {

    AntBuilder at(final Position position);

    AntBuilder withRotation(double rotation);

    AntBuilder withRandomness(RandomGenerator randomness);

    AntBuilder withInitialState(State state);

}
