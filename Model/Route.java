package Model;

public class Route {
    public String startLocation;
    public String destination;
    double cost;
    double estimatedTime;

    public Route(String startLocation, String destination, double cost, double estimatedTime) {
        this.startLocation = startLocation;
        this.destination = destination;
        this.cost = cost;
        this.estimatedTime = estimatedTime;
    }
}
