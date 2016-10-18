package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.Optional;
import java.util.function.Predicate;

public class Food implements ScenarioEntity {

    private static final int FOOD_SIZE = 2;
    private Position position;

    Food(Position position) {
        this.position = position;
    }

    @Override
    public int getRadius() {
        return FOOD_SIZE;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void moveTo(final Position newPosition) {
        this.position = newPosition;
    }

    public static Predicate<ScenarioEntity> food() {
        return entities -> entities instanceof Food;
    }

    public static Predicate<ScenarioEntity> foodStoredIn(Optional<Nest> nest) {
        if (nest.isPresent()) {
            return nest.get()::contains;
        }
        return (entity) -> false;
    }

    public static Predicate<ScenarioEntity> foodNotStoredIn(Optional<Nest> nest) {
        return foodStoredIn(nest);
    }
}
