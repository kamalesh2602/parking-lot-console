package com.kamal.parking;

import com.kamal.parking.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FloorTest {

    @Test
    void testFindAvailableCarSlot() {
        Floor floor = new Floor(1, 2, 1, 1);
        Vehicle car = new Car("TN01AB1234");

        ParkingSlot slot = floor.findAvailableSlot(car);

        assertNotNull(slot);
        assertEquals(VehicleType.CAR, slot.getSupportedType());
    }
}