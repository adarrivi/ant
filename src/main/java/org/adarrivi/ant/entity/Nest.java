package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.Collection;
import java.util.function.Predicate;

public class Nest implements ScenarioEntity {

    private static final int SIZE = 5;
    private final Position position;
    private final Collection<ScenarioEntity> store;

    Nest(Position position, Collection<ScenarioEntity> store) {
        this.position = position;
        this.store = store;
    }

    @Override
    public int getRadius() {
        return SIZE;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void storeFood(final Food food) {
        store.add(food);
    }

    public boolean contains(final ScenarioEntity entity) {
        return store.contains(entity);
    }

    public static Predicate<ScenarioEntity> nest() {
        return entities -> entities instanceof Nest;
    }
}
