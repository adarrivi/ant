package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.Collection;

public interface AntState {

    void act(final Ant ant, final Collection<ScenarioEntity> accessibleEntities);
}
