package org.adarrivi.ant.entity;

import org.adarrivi.ant.scenario.Position;

class FoodBuilderImpl implements FoodBuilder {

    private Position position;

    @Override
    public FoodBuilder at(Position position) {
        this.position = position;
        return this;
    }

    @Override
    public Food build() {
        return new Food(position);
    }

}
