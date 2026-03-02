package com.kamal.parking.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {

    private static int counter = 1;

    private final int ticketId;
    private final Vehicle vehicle;
    private final int floorNumber;
    private final int slotNumber;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(Vehicle vehicle, int floorNumber, int slotNumber) {
        this.ticketId = counter++;
        this.vehicle = vehicle;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.entryTime = LocalDateTime.now();
    }

    public void markExit() {
        this.exitTime = LocalDateTime.now();
    }

    public long getParkingDurationInMinutes() {
        if (exitTime == null) {
            throw new IllegalStateException("Vehicle has not exited yet");
        }
        return Duration.between(entryTime, exitTime).toMinutes();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
}