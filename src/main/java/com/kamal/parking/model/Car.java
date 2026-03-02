package com.kamal.parking.model;

public class Car extends Vehicle {

    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public String getType() {
        return "CAR";
    }
}