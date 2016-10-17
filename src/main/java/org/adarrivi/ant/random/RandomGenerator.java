package org.adarrivi.ant.random;

import java.util.Random;

public class RandomGenerator {

    private final Random random;
    private final long seed;

    public long getSeed() {
        return seed;
    }


    public RandomGenerator(long seed) {
        this.seed = seed;
        this.random = new Random(seed);
    }

    public boolean randomBoolean() {
        return random.nextBoolean();
    }

    public double randomRotation() {
        return random.nextDouble() * 2 * Math.PI;
    }
}
