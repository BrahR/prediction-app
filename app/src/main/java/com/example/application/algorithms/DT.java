package com.example.application.algorithms;

import com.example.application.Car;

public class DT extends Metrics {
    public void predict(int k) {
        for (Car car : Car.data) {
            String predicted = calc(car);
            predictedData.add(predicted);
        }
    }
    public static String calc(Car car) {
        String origin;

        if (car.getWeight() <= 1812.5) {
            if (car.getDisplacement() <= 94.5) return "japanese";

            return "american";
        }

        if (car.getHorsePower() <= 63.5) return "european";
        return "japanese";
    }
}