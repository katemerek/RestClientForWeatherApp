package ru.merkulova.RestClientForWeatherApp.util;

import java.util.Random;

public enum SensorsEnum {
    sensor_alfa,
    sensor_beta,
    sensor_delta,
    sensor_epsilon,
    sensor_gamma;

    private static final SensorsEnum[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public SensorsEnum getRandomSensor() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
