import java.util.ArrayList;

/**
 * Class that describes the solution for BestRoute problem
 */
public class BestRouteSolution {
    private int length;
    private ArrayList<Location> locations;
    private ArrayList<Road> roads;

    /**
     * Default constructor
     */
    public BestRouteSolution() {
        this.length = 0;
        this.locations = new ArrayList<Location>();
        this.roads = new ArrayList<Road>();
    }

    /**
     * Gets the length of the road
     * @return An int representing the length of the road
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the road
     * @param length An int representing the new length of the road
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the Location objects the BestRoute passes through
     * @return An ArrayList of Location objects
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Sets the ArrayList of Location objects
     * @param locations
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Gets the Road objects the BestRoute is made of
     * @return ArrayList of Road objects
     */
    public ArrayList<Road> getRoads() {
        return roads;
    }

    /**
     * Adds a new Location object to the ArrayList of Location objects
     * @param loc A Location object that will be added
     */
    public void addLocation(Location loc) {
        locations.add(loc);
    }

    /**
     * Adds a new Road object to the ArrayList of Road objects
     * @param road A Road object that will be added
     */
    public void addRoad(Road road) {
        roads.add(road);
    }

    /**
     * Sets the ArrayList of Road objects
     * @param roads
     */
    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }

    @Override
    public String toString() {
        return "BestRouteSolution{" +
                "length=" + length +
                ", locations=" + locations +
                ", roads=" + roads +
                '}';
    }
}
