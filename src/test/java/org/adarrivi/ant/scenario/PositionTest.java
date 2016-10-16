package org.adarrivi.ant.scenario;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.adarrivi.ant.scenario.Position.at;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PositionTest {

    @DataProvider
    public Object[][] addition() {
        return new Object[][]{
                {at(0, 0), at(3, 5), at(3, 5)},
                {at(2, 5), at(3, 5), at(5, 10)},
        };
    }

    @Test(dataProvider = "addition")
    public void addition_AddsPositions(Position position1, Position position2, Position expected) {
        assertThat(position1.add(position2), equalTo(expected));
    }

    @DataProvider
    public Object[][] subtraction() {
        return new Object[][]{
                {at(3, 5), at(0, 0), at(3, 5)},
                {at(12, 15), at(3, 5), at(9, 10)},
        };
    }

    @Test(dataProvider = "subtraction")
    public void subtraction_SubtractsPositions(Position position1, Position position2, Position expected) {
        assertThat(position1.subtract(position2), equalTo(expected));
    }

    @DataProvider
    public Object[][] distance() {
        return new Object[][]{
                {at(0, 0), at(3, 5), 5},
                {at(0, 0), at(3, 4), 5},
                {at(3, 5), at(0, 0), 5},
                {at(12, 15), at(3, 5), 13},
        };
    }

    @Test(dataProvider = "distance")
    public void distance_ReturnsDistance(Position position1, Position position2, int expected) {
        assertThat(position1.distance(position2), equalTo(expected));
    }
}