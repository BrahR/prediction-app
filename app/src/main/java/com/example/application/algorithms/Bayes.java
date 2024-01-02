package com.example.application.algorithms;

import com.example.application.Car;
import com.example.application.CarFloat;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Bayes implements PredictionAlgorithm{
    @Override
    public String calc(Car carToPred) {
        List<Car> cars = Car.data;

        int mgp = 0;
        int displacement = 0;
        int horsePow = 0;
        int weight = 0;
        int acceleration = 0;

        for (Car c : cars) {
            mgp += c.getMilesPerGallon();
            displacement += c.getDisplacement();
            horsePow += c.getHorsePower();
            weight += c.getWeight();
            acceleration += c.getAcceleration();
        }

        float avgMgp = (float) mgp / cars.size();
        float avgDisp = (float) displacement / cars.size();
        float avgHpow = (float) horsePow / cars.size();
        float avgWeight = (float) weight / cars.size();
        float avgAcc = (float) acceleration / cars.size();

        int japaneseCount = 0;
        int americanCount = 0;
        int europeanCount = 0;

        for (Car c : cars) {
            if (c.getOrigin().equals("japanese")) {
                japaneseCount++;
            } else if (c.getOrigin().equals("american")) {
                americanCount++;
            } else {
                europeanCount++;
            }
        }

        float japaneseProb = (float) japaneseCount / cars.size();
        float americanProb = (float) americanCount / cars.size();
        float europeanProb = (float) europeanCount / cars.size();

        CarFloat japanese = new CarFloat(0, 0, 0, 0, 0, 0);
        CarFloat american = new CarFloat(0, 0, 0, 0, 0, 0);
        CarFloat european = new CarFloat(0, 0, 0, 0, 0, 0);

        for (Car c : cars) {
            if (carToPred.getMilesPerGallon() >= avgMgp && c.getMilesPerGallon() >= avgMgp || carToPred.getMilesPerGallon() < avgMgp && c.getMilesPerGallon() < avgMgp) {
                if (c.getOrigin().equals("japanese")) {
                    japanese.setMilesPerGallon(japanese.getMilesPerGallon() + 1);
                } else if (c.getOrigin().equals("american")) {
                    american.setMilesPerGallon(american.getMilesPerGallon() + 1);
                } else {
                    european.setMilesPerGallon(european.getMilesPerGallon() + 1);
                }
            }
            if (carToPred.getDisplacement() >= avgDisp && c.getDisplacement() >= avgDisp || carToPred.getDisplacement() < avgDisp && c.getDisplacement() < avgDisp) {
                if (c.getOrigin().equals("japanese")) {
                    japanese.setDisplacement(japanese.getDisplacement() + 1);
                } else if (c.getOrigin().equals("american")) {
                    american.setDisplacement(american.getDisplacement() + 1);
                } else {
                    european.setDisplacement(european.getDisplacement() + 1);
                }
            }
            if (carToPred.getHorsePower() >= avgHpow && c.getHorsePower() >= avgHpow || carToPred.getHorsePower() < avgHpow && c.getHorsePower() < avgHpow) {
                if (c.getOrigin().equals("japanese")) {
                    japanese.setHorsePower(japanese.getHorsePower() + 1);
                } else if (c.getOrigin().equals("american")) {
                    american.setHorsePower(american.getHorsePower() + 1);
                } else {
                    european.setHorsePower(european.getHorsePower() + 1);
                }
            }
            if (carToPred.getWeight() >= avgHpow && c.getWeight() >= avgHpow || carToPred.getWeight() < avgHpow && c.getWeight() < avgHpow) {
                if (c.getOrigin().equals("japanese")) {
                    japanese.setWeight(japanese.getWeight() + 1);
                } else if (c.getOrigin().equals("american")) {
                    american.setWeight(american.getWeight() + 1);
                } else {
                    european.setWeight(european.getWeight() + 1);
                }
            }
            if (carToPred.getAcceleration() >= avgAcc && c.getAcceleration() >= avgAcc || carToPred.getAcceleration() < avgAcc && c.getAcceleration() < avgAcc) {
                if (c.getOrigin().equals("japanese")) {
                    japanese.setAcceleration(japanese.getAcceleration() + 1);
                } else if (c.getOrigin().equals("american")) {
                    american.setAcceleration(american.getAcceleration() + 1);
                } else {
                    european.setAcceleration(european.getAcceleration() + 1);
                }
            }
        }

        List<CarFloat> floatCars = new ArrayList<>();
        floatCars.add(japanese);
        floatCars.add(american);
        floatCars.add(european);

        int count = japaneseCount;
        double prob = japaneseProb;
        for (int i = 0; i < floatCars.size(); i++) {
            if (i == 1) {
                count = americanCount;
                prob = americanProb;
            } else if (i == 2) {
                count = europeanCount;
                prob = europeanProb;
            }
            CarFloat car = floatCars.get(i);
            car.setMilesPerGallon(car.getMilesPerGallon() / count);
            car.setDisplacement(car.getDisplacement() / count);
            car.setHorsePower(car.getHorsePower() / count);
            car.setWeight(car.getWeight() / count);
            car.setAcceleration(car.getAcceleration() / count);
            car.setResult(
                prob *
                car.getMilesPerGallon() *
                car.getDisplacement() *
                car.getHorsePower() *
                car.getWeight() *
                car.getAcceleration()
            );
        }

        if (floatCars.get(0).getResult() > floatCars.get(1).getResult() && floatCars.get(0).getResult() > floatCars.get(2).getResult()) {
            return "Your car is Japanese";
        } else if (floatCars.get(1).getResult() > floatCars.get(0).getResult() && floatCars.get(1).getResult() > floatCars.get(2).getResult()) {
            return "Your car is American";
        } else {
            return "Your car is European";
        }
    }

    @Override
    public String calc(Car car, int k) {
        return this.calc(car);
    }
}