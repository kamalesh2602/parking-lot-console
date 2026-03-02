package com.kamal.parking.service;

import com.kamal.parking.model.*;

import java.util.*;

public class ParkingLot {

    private static ParkingLot instance;

    private final List<Floor> floors;
    private final Map<Integer, Ticket> activeTickets;

    private ParkingLot(int totalFloors, int carSlots, int bikeSlots, int truckSlots) {
        this.floors = new ArrayList<>();
        this.activeTickets = new HashMap<>();

        for (int i = 1; i <= totalFloors; i++) {
            floors.add(new Floor(i, carSlots, bikeSlots, truckSlots));
        }
    }

    // Singleton getInstance
    public static ParkingLot getInstance(int totalFloors,
                                         int carSlots,
                                         int bikeSlots,
                                         int truckSlots) {

        if (instance == null) {
            instance = new ParkingLot(totalFloors, carSlots, bikeSlots, truckSlots);
        }
        return instance;
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        for (Floor floor : floors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle);

            if (slot != null) {
                slot.park(vehicle);

                Ticket ticket = new Ticket(
                        vehicle,
                        floor.getFloorNumber(),
                        slot.getSlotNumber()
                );

                activeTickets.put(ticket.getTicketId(), ticket);

                return ticket;
            }
        }

        return null; // Parking Full
    }

    public long exitVehicle(int ticketId) {

        Ticket ticket = activeTickets.get(ticketId);

        if (ticket == null) {
            throw new IllegalArgumentException("Invalid Ticket ID");
        }

        ticket.markExit();

        // Free slot
        Floor floor = floors.get(ticket.getFloorNumber() - 1);
        ParkingSlot slot = floor.getSlots().get(ticket.getSlotNumber() - 1);
        slot.unpark();

        activeTickets.remove(ticketId);

        return ticket.getParkingDurationInMinutes();
    }

    public void displayAvailability() {
        for (Floor floor : floors) {
            System.out.println("Floor " + floor.getFloorNumber());

            for (ParkingSlot slot : floor.getSlots()) {
                System.out.println("Slot "
                        + slot.getSlotNumber()
                        + " [" + slot.getSupportedType() + "] - "
                        + (slot.isOccupied() ? "Occupied" : "Available"));
            }
        }
    }
}