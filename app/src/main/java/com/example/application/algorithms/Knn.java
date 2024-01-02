package com.example.application.algorithms;

import com.example.application.Car;

import java.util.*;

public class Knn {
    public static String calc(Car car, int k) {
        ArrayList<Double> distances = new ArrayList<>();
        for (Car c : Car.data) {
            distances.add(car.distance(c));
        }

        ArrayList<Double> sortedDistances = new ArrayList<>(distances);
        Collections.sort(sortedDistances);

        HashMap<String, Integer> origins = new HashMap<>() {{
            put(Car.ORIGINS[0], 0);
            put(Car.ORIGINS[1], 0);
            put(Car.ORIGINS[2], 0);
        }};

        for (int i = 0; i < k; i++) {
            double distance = sortedDistances.get(i);
            int index = distances.indexOf(sortedDistances.get(i));
            String origin = Car.data.get(index).getOrigin();
            origins.put(origin, origins.get(origin) + 1);

            if (distance == 0) break;
        }

        return "Your car is " + Collections.max(origins.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
