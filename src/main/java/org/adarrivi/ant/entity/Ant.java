package org.adarrivi.ant.entity;

import org.adarrivi.ant.entity.state.State;
import org.adarrivi.ant.random.RandomGenerator;
import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;

import java.util.Collection;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.adarrivi.ant.entity.Food.food;
import static org.adarrivi.ant.entity.Food.foodStoredIn;
import static org.adarrivi.ant.entity.Nest.nest;

public class Ant implements ScenarioEntity {

    private static final double ROTATION_DELTA = 0.1;
    private static final int FORWARD_STEP_DISTANCE = 3;
    private static final int SIZE = 3;

    private final RandomGenerator randomGenerator;
    private Position position;
    private double rotation;
    private State state;
    private Optional<Food> carryingFood = empty();

    Ant(Position position, double rotation, State initialState, RandomGenerator randomGenerator) {
        this.position = position;
        this.rotation = rotation;
        this.state = initialState;
        this.randomGenerator = randomGenerator;
    }

    @Override
    public int getRadius() {
        return SIZE;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void moveRandomlyForward() {
        rotation += randomGenerator.randomBoolean() ? ROTATION_DELTA : -ROTATION_DELTA;
        position = position.move(rotation, FORWARD_STEP_DISTANCE);
    }

    void act(final Collection<ScenarioEntity> visibleEntities) {
        predeterminedBehavior(visibleEntities);
        state.act(this, visibleEntities);
    }

    @SuppressWarnings({"unchecked"})
    private void predeterminedBehavior(final Collection<ScenarioEntity> visibleEntities) {
        final Optional<ScenarioEntity> nestAccessible = visibleEntities.stream()
                .filter(nest())
                .findAny();
        final Optional<ScenarioEntity> foodAccessible = visibleEntities.stream()
                .filter(food())
                .filter(foodStoredIn((Optional) nestAccessible).negate())
                .findAny();

        if (carryingFood.isPresent() && nestAccessible.isPresent()) {
            ((Nest) nestAccessible.get()).storeFood(carryingFood.get());
            carryingFood = empty();
        } else if (foodAccessible.isPresent() && !carryingFood.isPresent()) {
            carryingFood = (Optional) foodAccessible;
        }
    }

    public boolean isCarryingFood() {
        return carryingFood.isPresent();
    }

    void catchFood(Food food) {
        carryingFood = of(food);
    }

    Optional<Food> showCarryingFood() {
        return carryingFood;
    }
}
