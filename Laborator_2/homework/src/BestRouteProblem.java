import java.util.ArrayList;

/**
 * Class that contains locations and roads
 * @author andreeaolariu
 */
public class BestRouteProblem {
    private ArrayList<Location> locations;
    private ArrayList<Road> roads;

    /**
     * The default constructor
     * It initialises data members
     */
     BestRouteProblem() {
        locations = new ArrayList<Location>();
        roads = new ArrayList<Road>();
    }

    /**
     * Constructor
     * @param _locations An ArrayList of objects of type Location
     * @param _roads An ArrayList of objects of type Road
     */
    BestRouteProblem(ArrayList<Location> _locations, ArrayList<Road> _roads) {
        locations = _locations;
        roads = _roads;
    }

    /**
     * Gets the locations
     * @return ArrayList<Location> representing the locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Sets the locations
     * @param locations An ArrayList<Location> representing the new value of locations data member
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Gets the roads
     * @return An ArrayList<Road> representing the roads data member
     */
    public ArrayList<Road> getRoads() {
        return roads;
    }

    /**
     * Sets the roads
     * @param roads An ArrayList<Road> representing the new value of roads data member
     */
    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }

    /**
     * Adds a new location to the locations data member
     * @param newLocation A Location object added to the locations data member
     */
    public void addLocation(Location newLocation) {
        for(Location loc : this.locations) {
            if(loc.equals(newLocation)) {
                return;
            }
        }
        this.locations.add(newLocation);
    }

    /**
     * Adds a new road to the roads data member
     * @param newRoad A Road object added to the roads data member
     */
    public void addRoute(Road newRoad) {
        for(Road road : this.roads) {
            if(road.equals(newRoad)) {
                return;
            }
        }
        this.roads.add(newRoad);
    }

    /**
     * Cheks if all the locations that make up the roads are in the locations data member
     * @return <ul>A boolean value: <li><strong>true</strong> if the instance is valid</li><li><strong>false</strong> if the instance is not valid</li></ul>
     */
    public boolean validInstance() {
        for(Road road : roads) {
            if(!locations.contains(road)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there is a road between two locations given as parameters by constructing the graph of the roads
     * @param x A Location Object representing one of the locations
     * @param y A Location Object representing the other location locations
     * @return <ul>A boolean value: <li>true</li> if there is a road between these two locations <li>false</li> if there isn't a road between these two locations</ul>
     */
    public boolean isAnyRoad(Location x, Location y) {
        Graph roadsGraph = new Graph(locations, roads);
        return roadsGraph.checkIfConnected(x, y);
    }
}
