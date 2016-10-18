package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;

public interface NestBuilder extends Builder<Nest> {

    NestBuilder at(final Position position);

    NestBuilder storeWith(final ScenarioEntity entity);

}
