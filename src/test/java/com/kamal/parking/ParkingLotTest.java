package com.kamal.parking;

import com.kamal.parking.model.Car;
import com.kamal.parking.model.Ticket;
import com.kamal.parking.service.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void testParkingFlow() {

        ParkingLot lot = ParkingLot.getInstance(1, 1, 0, 0);

        Car car = new Car("TN01AB1234");
        Ticket ticket = lot.parkVehicle(car);

        assertNotNull(ticket);

        long duration = lot.exitVehicle(ticket.getTicketId());

        assertTrue(duration >= 0);
    }
}