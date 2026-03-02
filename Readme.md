**🚗 Parking Lot Management System (Console-Based)
📌 Overview**

This is a console-based Parking Lot Management System built using Java 17, following proper Object-Oriented Programming (OOP) principles and industry-standard project structure using Maven.
The system simulates a real-world multi-floor parking lot with support for different vehicle types and automatic slot allocation.

**🎯 Features**

Park vehicles (Car, Bike, Truck)
Automatic slot allocation based on vehicle type
Generate parking tickets
Track entry and exit time
Calculate parking duration
Display slot availability
Menu-driven console interface
Unit testing using JUnit 5
CI/CD pipeline using GitHub Actions

**🏗 Architecture**

The project follows a layered design:

model/ → Core domain models (Vehicle, Slot, Floor, Ticket)

service/ → Business logic (ParkingLot singleton)

Main.java → Console UI layer

This separation ensures clean architecture and maintainability.

**🧠 OOP Concepts Used**

Abstraction
Inheritance
Polymorphism
Encapsulation
Composition & Aggregation
Singleton Design Pattern
Enum usage
Collections (List, Map)

**🛠 Tech Stack**
Java 17
Maven
JUnit 5
GitHub Actions (CI/CD)

**🚀 How to Run**
mvn clean install
mvn exec:java -Dexec.mainClass="com.kamal.parking.Main"

**📈 Learning Goals**

This project was built to:
Strengthen OOP fundamentals
Practice layered architecture

Understand multi-class Java project structure

Integrate CI/CD with Maven
