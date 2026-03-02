package com.kamal.parking.model;

public class ParkingSlot {

    private final int slotNumber;
    private final VehicleType supportedType;
    private Vehicle parkedVehicle;

    public ParkingSlot(int slotNumber, VehicleType supportedType) {
        this.slotNumber = slotNumber;
        this.supportedType = supportedType;
        this.parkedVehicle = null;
    }

    public boolean isOccupied() {
        return parkedVehicle != null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return !isOccupied() && vehicle.getType() == supportedType;
    }

    public void park(Vehicle vehicle) {
        if (!canFitVehicle(vehicle)) {
            throw new IllegalArgumentException("Vehicle cannot be parked in this slot");
        }
        this.parkedVehicle = vehicle;
    }

    public void unpark() {
        this.parkedVehicle = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleType getSupportedType() {
        return supportedType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}