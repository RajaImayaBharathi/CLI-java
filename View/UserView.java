package View;
import Model.*;

import java.util.List;
import java.util.Scanner;

public class UserView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMenu() {
        System.out.println("\n1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public String getUsername() {
        
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.print("Enter password: ");
        return scanner.nextLine();
    }

    public void displayRoutes(List<Route> routes) {
        System.out.println("Available Routes:");
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            System.out.println((i + 1) + ". " + route.startLocation + " to " + route.destination);
        }
    }

    public String getPlan() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.print("Select plan (Basic/Fast): ");
        return scanner.nextLine();
    }

    public void displayShipmentDetails(Shipment shipment) {
        System.out.println("Shipment ID: " + shipment.shipmentId);
        System.out.println("From: " + shipment.startLocation + " To: " + shipment.destination);
        System.out.println("Plan: " + shipment.plan);
        System.out.println("Status: " + shipment.status);
    }

    public String getShipmentId() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.print("Enter Shipment ID: ");
        return scanner.nextLine();
    }

    public void displayInvalidOption() {
        System.out.println("Invalid option! Please try again.");
    }
}

