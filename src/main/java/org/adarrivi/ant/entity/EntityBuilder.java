package org.adarrivi.ant.entity;

public class EntityBuilder {

    public static <T> T given(Builder<T> builder) {
        return builder.build();
    }

    public static FoodBuilder food() {
        return new FoodBuilderImpl();
    }

    public static NestBuilder nest() {
        return new NestBuilderImpl();
    }

    public static AntBuilder ant() {
        return new AntBuilderImpl();
    }
}
