package com.kamal.parking;

import com.kamal.parking.model.Car;
import com.kamal.parking.model.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    void testCarType() {
        Car car = new Car("TN01AB1234");
        assertEquals(VehicleType.CAR, car.getType());
    }
}