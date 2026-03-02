package com.kamal.parking;

import com.kamal.parking.model.Car;
import com.kamal.parking.model.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    void testTicketCreation() {
        Car car = new Car("TN01AB1234");
        Ticket ticket = new Ticket(car, 1, 2);

        assertEquals(car, ticket.getVehicle());
        assertEquals(1, ticket.getFloorNumber());
        assertEquals(2, ticket.getSlotNumber());
        assertNotNull(ticket.getEntryTime());
    }
}