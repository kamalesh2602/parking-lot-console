package com.kamal.parking;

import com.kamal.parking.model.*;
import com.kamal.parking.service.ParkingLot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize ParkingLot (1 floor, 2 car, 2 bike, 1 truck slots)
        ParkingLot lot = ParkingLot.getInstance(1, 2, 2, 1);

        while (true) {
            System.out.println("\n===== Parking Lot System =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Availability");
            System.out.println("4. Exit System");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter vehicle type (CAR/BIKE/TRUCK): ");
                    String typeInput = scanner.nextLine().toUpperCase();

                    System.out.print("Enter license plate: ");
                    String plate = scanner.nextLine();

                    Vehicle vehicle = createVehicle(typeInput, plate);

                    if (vehicle == null) {
                        System.out.println("Invalid vehicle type.");
                        break;
                    }

                    Ticket ticket = lot.parkVehicle(vehicle);

                    if (ticket == null) {
                        System.out.println("Parking Full!");
                    } else {
                        System.out.println("Vehicle Parked Successfully!");
                        System.out.println("Ticket ID: " + ticket.getTicketId());
                        System.out.println("Floor: " + ticket.getFloorNumber());
                        System.out.println("Slot: " + ticket.getSlotNumber());
                    }
                    break;

                case 2:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = scanner.nextInt();

                    try {
                        long duration = lot.exitVehicle(ticketId);
                        System.out.println("Vehicle Exited.");
                        System.out.println("Duration (minutes): " + duration);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    lot.displayAvailability();
                    break;

                case 4:
                    System.out.println("Exiting System...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private static Vehicle createVehicle(String type, String plate) {

        switch (type) {
            case "CAR":
                return new Car(plate);
            case "BIKE":
                return new Bike(plate);
            case "TRUCK":
                return new Truck(plate);
            default:
                return null;
        }
    }
}