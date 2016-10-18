package org.adarrivi.ant.entity;

import org.adarrivi.ant.random.RandomGenerator;
import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.adarrivi.ant.entity.EntityBuilder.*;
import static org.adarrivi.ant.entity.state.StateBuilder.rummage;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AntTest {
    private Ant victim;
    private Collection<ScenarioEntity> visibleEntities;

    @BeforeMethod
    public void setUp() {
        visibleEntities = new ArrayList<>();
    }

    @Test
    public void act_noEntitiesVisible_DoesNotCarryFood() {
        givenEmptyAndRummaging();
        whenAct();
        thenIsNotCarryingFood();
    }

    private void givenEmptyAndRummaging() {
        victim = given(ant()
                .at(Position.at(0, 0))
                .withInitialState(rummage())
                .withRandomness(new RandomGenerator(System.currentTimeMillis()))
        );
    }


    private void whenAct() {
        victim.act(visibleEntities);
    }

    private void thenIsNotCarryingFood() {
        assertThat(victim.isCarryingFood(), is(false));
    }

    @Test
    public void act_EmptyNest_DoesNotCarryFood() {
        givenEmptyAndRummaging();
        givenEmptyNest();
        whenAct();
        thenIsNotCarryingFood();
    }

    private boolean givenEmptyNest() {
        return visibleEntities.add(given(nest()));
    }


    @Test
    public void act_EmptyAnt_NestWithFoodStored_DoesNotCarryFood() {
        givenEmptyAndRummaging();
        givenNestWithFood();
        whenAct();
        thenIsNotCarryingFood();
    }

    private void givenNestWithFood() {
        final Food food = given(food());
        final Nest nest = given(nest().storeWith(food));
        visibleEntities.add(food);
        visibleEntities.add(nest);
    }

    @Test
    public void act_AntCarrying_Food_AntKeepsFood() {
        final Food foodBeingCarried = givenAntWithFood();
        givenFood();
        whenAct();
        thenAntIsCarrying(foodBeingCarried);
    }

    private Food givenAntWithFood() {
        givenEmptyAndRummaging();
        final Food food = given(food());
        victim.catchFood(food);
        visibleEntities.add(food);
        return food;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private void thenAntIsCarrying(Food expected) {
        thenIsCarryingFood();
        assertThat(victim.showCarryingFood().get(), equalTo(expected));
    }

    @Test
    public void act_EmptyAnt_Food_AntCatchesFood() {
        givenEmptyAndRummaging();
        givenFood();
        whenAct();
        thenIsCarryingFood();
    }

    private void givenFood() {
        visibleEntities.add(given(food()));
    }

    private void thenIsCarryingFood() {
        assertThat(victim.isCarryingFood(), is(true));
    }


}