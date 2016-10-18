package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.ArrayList;
import java.util.Collection;


class NestBuilderImpl implements NestBuilder {

    private Position position;
    private Collection<ScenarioEntity> store = new ArrayList<>();

    @Override
    public NestBuilder at(Position position) {
        this.position = position;
        return this;
    }

    @Override
    public NestBuilder storeWith(ScenarioEntity entity) {
        store.add(entity);
        return this;
    }

    @Override
    public Nest build() {
        return new Nest(position, store);
    }
}
