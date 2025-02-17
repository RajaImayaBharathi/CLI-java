package Model;

public class Shipment {
    public String shipmentId;
    public String startLocation;
    public String destination;
    public String plan; // Basic or Fast
    public String status; // Pending, In-Transit, Delivered
    public boolean isPaid;

    public Shipment(String shipmentId, String startLocation, String destination, String plan) {
        this.shipmentId = shipmentId;
        this.startLocation = startLocation;
        this.destination = destination;
        this.plan = plan;
        this.status = "Pending";
        this.isPaid = false;
    }
}
