package com.example.application;

public class CarFloat {
    private double milesPerGallon;
    private double displacement;
    private double horsePower;
    private double weight;
    private double acceleration;

    private double result;

    public CarFloat(double milesPerGallon, double displacement, double horsePower, double weight, double acceleration,double result) {
        this.milesPerGallon = milesPerGallon;
        this.displacement = displacement;
        this.horsePower = horsePower;
        this.weight = weight;
        this.acceleration = acceleration;
        this.result=result;
    }

    @Override
    public String toString() {
        return "CarFloat{" +
                "milesPerGallon=" + milesPerGallon +
                ", displacement=" + displacement +
                ", horsePower=" + horsePower +
                ", weight=" + weight +
                ", acceleration=" + acceleration +
                ", result=" + result +
                '}';
    }

    public void setMilesPerGallon(double milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    public double getDisplacement() {
        return displacement;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public double getWeight() {
        return weight;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getResult() {
        return result;
    }
}
