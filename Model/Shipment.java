package Model;

public class Shipment {
    String shipmentId;
    String startLocation;
    String destination;
    String plan; // Basic or Fast
    String status; // Pending, In-Transit, Delivered
    boolean isPaid;

    Shipment(String shipmentId, String startLocation, String destination, String plan) {
        this.shipmentId = shipmentId;
        this.startLocation = startLocation;
        this.destination = destination;
        this.plan = plan;
        this.status = "Pending";
        this.isPaid = false;
    }
}
