package Controller;
import View.*;
import Model.*;
import java.util.*;

public class UserController {
    private UserView userView;
    private Map<String, User> users;
    private Map<String, Shipment> shipments;
    private List<Route> routes;

    public UserController(UserView userView) {
        this.userView = userView;
        this.users = new HashMap<>();
        this.shipments = new HashMap<>();
        this.routes = new ArrayList<>();
        
        // Preload with a default admin user
        users.put("admin", new User("admin", "admin123", "1234567890", "Admin Address", true));
        
        // Preload some routes
        routes.add(new Route("New York", "London", 500, 7));
        routes.add(new Route("Los Angeles", "Tokyo", 600, 8));
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        
        String username = userView.getUsername();
        scanner.nextLine();
        String password = userView.getPassword();
        scanner.nextLine();
        
        if (users.containsKey(username) && users.get(username).password.equals(password)) {
            userView.displayMessage("Login successful!");
            if (users.get(username).isAdmin) {
                adminMenu();
            } else {
                customerMenu();
            }
        } else {
            userView.displayMessage("Invalid username or password.");
        }

        scanner.close();
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        
        String username = userView.getUsername();
        String password = userView.getPassword();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        users.put(username, new User(username, password, phoneNumber, address, false));
        userView.displayMessage("Registration successful!");
        scanner.close();
    }

    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Book Shipment");
            System.out.println("2. Make Payment");
            System.out.println("3. Track Shipment Status");
            System.out.println("4. Cancel Shipment");
            System.out.println("5. Help Center");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    bookShipment();
                    break;
                case 2:
                    makePayment();
                    break;
                case 3:
                    trackShipment();
                    break;
                case 4:
                    cancelShipment();
                    break;
                case 5:
                    helpCenter();
                    break;
                case 6:
                    return;
                default:
                    userView.displayInvalidOption();
            }
            scanner.close();
        }
    }

    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Create & Manage Routes");
            System.out.println("2. View & Update Shipment Status");
            System.out.println("3. View Payments");
            System.out.println("4. Cancel Shipments");
            System.out.println("5. View All Bookings");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    manageRoutes();
                    break;
                case 2:
                    updateShipmentStatus();
                    break;
                case 3:
                    viewPayments();
                    break;
                case 4:
                    cancelShipment();
                    break;
                case 5:
                    viewAllBookings();
                    break;
                case 6:
                    return;
                default:
                    userView.displayInvalidOption();
            }
            scanner.close();
        }
    }

    public void bookShipment() {
        userView.displayRoutes(routes);
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        int routeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Route selectedRoute = routes.get(routeChoice - 1);

        String plan = userView.getPlan();
        
        String shipmentId = UUID.randomUUID().toString();
        Shipment shipment = new Shipment(shipmentId, selectedRoute.startLocation, selectedRoute.destination, plan);
        shipments.put(shipmentId, shipment);
        
        userView.displayMessage("Shipment booked successfully! Shipment ID: " + shipmentId);
    }

    public void makePayment() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        String shipmentId = userView.getShipmentId();
        
        if (shipments.containsKey(shipmentId) && !shipments.get(shipmentId).isPaid) {
            shipments.get(shipmentId).isPaid = true;
            userView.displayMessage("Payment made successfully!");
        } else {
            userView.displayMessage("Shipment not found or already paid.");
        }
    }

    public void trackShipment() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        String shipmentId = userView.getShipmentId();
        
        if (shipments.containsKey(shipmentId)) {
            userView.displayShipmentDetails(shipments.get(shipmentId));
        } else {
            userView.displayMessage("Shipment not found.");
        }
    }

    public void cancelShipment() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        String shipmentId = userView.getShipmentId();
        
        if (shipments.containsKey(shipmentId)) {
            shipments.remove(shipmentId);
            userView.displayMessage("Shipment canceled successfully.");
        } else {
            userView.displayMessage("Shipment not found.");
        }
    }

    public void helpCenter() {
        userView.displayMessage("Welcome to the Help Center. For assistance, contact our customer support.");
    }

    public void manageRoutes() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.print("Enter start location: ");
        String startLocation = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter cost: ");
        double cost = scanner.nextDouble();
        System.out.print("Enter estimated time (in days): ");
        double estimatedTime = scanner.nextDouble();
        
        routes.add(new Route(startLocation, destination, cost, estimatedTime));
        userView.displayMessage("Route added successfully!");
    }

    public void updateShipmentStatus() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        String shipmentId = userView.getShipmentId();
        
        if (shipments.containsKey(shipmentId)) {
            System.out.println("Current Status: " + shipments.get(shipmentId).status);
            System.out.print("Enter new status (Pending, In-Transit, Delivered): ");
            String status = scanner.nextLine();
            shipments.get(shipmentId).status = status;
            userView.displayMessage("Shipment status updated.");
        } else {
            userView.displayMessage("Shipment not found.");
        }
    }

    public void viewPayments() {
        userView.displayMessage("Payment details are accessible only by authorized personnel.");
    }

    public void viewAllBookings() {
        for (Shipment shipment : shipments.values()) {
            userView.displayShipmentDetails(shipment);
        }
    }
}

