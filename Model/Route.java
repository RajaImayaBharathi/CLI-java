package Model;

public class Route {
    String startLocation;
    String destination;
    double cost;
    int distance;
    double estimatedTime;

    public Route(String startLocation, String destination, double cost, int distance,double estimatedTime) {
        this.startLocation = startLocation;
        this.destination = destination;
        this.cost = cost;
        this.distance=distance;
        this.estimatedTime = estimatedTime;
    }
}
