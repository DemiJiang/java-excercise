public class Destination {
    private Town<String> town;
    private int distance;

    public Destination(Town<String> town, int distance) {
        this.town = town;
        this.distance = distance;
    }

    public Town<String> geTown() {
        return town;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return town + " Distance " + distance;
    }


}
