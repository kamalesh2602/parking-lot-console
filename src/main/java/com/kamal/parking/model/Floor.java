package com.kamal.parking.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final int floorNumber;
    private final List<ParkingSlot> slots;

    public Floor(int floorNumber, int carSlots, int bikeSlots, int truckSlots) {
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();

        int slotCounter = 1;

        // Create CAR slots
        for (int i = 0; i < carSlots; i++) {
            slots.add(new ParkingSlot(slotCounter++, VehicleType.CAR));
        }

        // Create BIKE slots
        for (int i = 0; i < bikeSlots; i++) {
            slots.add(new ParkingSlot(slotCounter++, VehicleType.BIKE));
        }

        // Create TRUCK slots
        for (int i = 0; i < truckSlots; i++) {
            slots.add(new ParkingSlot(slotCounter++, VehicleType.TRUCK));
        }
    }

    public ParkingSlot findAvailableSlot(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (slot.canFitVehicle(vehicle)) {
                return slot;
            }
        }
        return null;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}