package com.kamal.parking.model;

public class Bike extends Vehicle {

    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}