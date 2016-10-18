package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.Position;

public interface FoodBuilder extends Builder<Food> {

    FoodBuilder at(final Position position);

}
