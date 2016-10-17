package org.adarrivi.ant.random;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class RandomGeneratorTest {

    private static final int RANDOM_SEQUENCE_SAMPLE_SIZE = 10;

    @Test
    public void randomRotation_SameSeed_ReturnsSameRandomValues() {
        final long seed = System.currentTimeMillis();
        final List<Double> expectedRandomDoubles = givenRandomDoublesForSeed(seed, RandomGenerator::randomRotation);
        final List<Double> randomDoubles = givenRandomDoublesForSeed(seed, RandomGenerator::randomRotation);
        assertThat(randomDoubles, equalTo(expectedRandomDoubles));
    }

    private List<Double> givenRandomDoublesForSeed(long seed, Function<RandomGenerator, Double> function) {
        final RandomGenerator randomGenerator = new RandomGenerator(seed);
        final ArrayList<Double> doubles = new ArrayList<>();
        for (int i = 0; i < RANDOM_SEQUENCE_SAMPLE_SIZE; i++) {
            doubles.add(function.apply(randomGenerator));
        }
        return doubles;
    }

    @Test
    public void randomRotation_DifferentSeed_ReturnsDifferentRandomValues() {
        final long seed = System.currentTimeMillis();
        final List<Double> expectedRandomDoubles = givenRandomDoublesForSeed(seed, RandomGenerator::randomRotation);
        final List<Double> randomDoubles = givenRandomDoublesForSeed(seed * 2, RandomGenerator::randomRotation);
        assertThat(randomDoubles, not(equalTo(expectedRandomDoubles)));
    }
}