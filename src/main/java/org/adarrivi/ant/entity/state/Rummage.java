package org.adarrivi.ant.entity.state;

import org.adarrivi.ant.entity.Ant;
import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.Collection;

class Rummage implements State {

    @Override
    public void act(Ant ant, Collection<ScenarioEntity> accessibleEntities) {
        ant.moveRandomlyForward();
    }
}
