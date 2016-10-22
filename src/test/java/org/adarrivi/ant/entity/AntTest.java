package org.adarrivi.ant.entity;

import org.adarrivi.ant.random.RandomGenerator;
import org.adarrivi.ant.scenario.Position;
import org.adarrivi.ant.scenario.ScenarioEntity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.asList;
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
        victim = givenEmptyAndRummaging();
        visibleEntities = new ArrayList<>();
    }

    private Ant givenEmptyAndRummaging() {
        return given(ant()
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



    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private void thenAntIsCarrying(Food expected) {
        thenIsCarryingFood();
        assertThat(victim.showCarryingFood().get(), equalTo(expected));
    }


    private void thenIsCarryingFood() {
        assertThat(victim.isCarryingFood(), is(true));
    }

    @Test
    public void isCarryingFood_AntEmpty_Food_PicksUpFood() {
        visibleEntities.add(given(food()));
        whenAct();
        thenIsCarryingFood();
    }

    @Test
    public void isCarryingFood_AntEmpty_NestEmptyFood_PicksUpFood() {
        visibleEntities.add(givenEmptyNest());
        visibleEntities.add(given(food()));
        whenAct();
        thenIsCarryingFood();
    }

    @Test
    public void isCarryingFood_AntEmpty_NestWithFoodAndFood_PicksUpFood() {
        visibleEntities.addAll(givenNestWithFood());
        visibleEntities.add(given(food()));
        whenAct();
        thenIsCarryingFood();
    }

    private ScenarioEntity givenEmptyNest() {
        return given(nest());
    }

    private Collection<ScenarioEntity> givenNestWithFood() {
        final Nest nest = given(nest());
        final Food food = given(food());
        nest.storeFood(food);
        return asList(nest, food);
    }

    @Test
    public void isCarryingFood_AntEmpty_noEntitiesVisible_DoesNotCarryFood() {
        whenAct();
        thenIsNotCarryingFood();
    }

    @Test
    public void isCarryingFood_AntEmpty_NestWithFood_DoesNotPickUpFood() {
        visibleEntities.addAll(givenNestWithFood());
        whenAct();
        thenIsNotCarryingFood();
    }

    @Test
    public void isCarryingFood_AntEmpty_DoesNotPickUpFood() {
        whenAct();
        thenIsNotCarryingFood();
    }

    @Test
    public void isCarryingFood_AntEmpty_NestEmpty_DoesNotPickUpFood() {
        visibleEntities.add(givenEmptyNest());
        whenAct();
        thenIsNotCarryingFood();
    }
}