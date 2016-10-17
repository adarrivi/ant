package org.adarrivi.ant.entity.state;

import org.adarrivi.ant.entity.Ant;
import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.Collection;

public interface State {

    void act(final Ant ant, final Collection<ScenarioEntity> accessibleEntities);
}
