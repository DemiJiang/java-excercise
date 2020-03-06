package substitution_principle_wildcards;

public class House extends Building {
    public int numberOfRooms = 10;

    @Override
    public String toString() {
        return super.toString();
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
