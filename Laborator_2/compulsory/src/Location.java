/**
 * This class is used for storing information about a location.
 * @author andreeaolariu
 *
 */

public class Location {
    /**
     * Represents the type of the location.
     */
    public static enum LocationType {
        CITY,
        AIRPORT,
        GAS_STATION;
    }

    private String name;
    private LocationType type;
    private float x;
    private float y;

    /**
     * Creates a new Location object
     * @param name A String representing the name of the location
     * @param t A LocationType representing the type of the location
     * @param x An int representing the x coordinate of the location
     * @param y An int representing the y coordinate of the location
     */
    Location(String name, LocationType t, int x, int y) {
        this.name = name;
        this.type = t;
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the name of the location.
     * @return A string representing the name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the location
     * @param name A string representing the name of the location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the x coordinate of the location
     * @return A float representing the x coordinate of the location
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the y coordinate of the location
     * @param x A float representing the x coordinate of the location
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets the y coordinate of the location
     * @return A float representing the y coordinate of the location
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the location
     * @param y A float representing the x coordinate of the location
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Gets the type of the location
     * @return a LocationType object representing the type of the location
     */
    public LocationType getType() {
        return type;
    }

    /**
     * Sets the type of the location
     * @param type A LocationType object representing the type of the location
     */
    public void setType(LocationType type) {
        this.type = type;
    }

    /**
     * Gets the String format of the object
     * @return A string representing information
     * about the object
     */
    @Override
    public String toString() {
        String objectInfo = "The ";
        switch(this.getType()) {
            case CITY:
                objectInfo += "city ";
                break;
            case AIRPORT:
                objectInfo += "airport ";
                break;
            case GAS_STATION:
                objectInfo += "gas station ";
                break;
            default:
                break;
        }
        objectInfo += "is named " + this.getName() +  " and has the coordinates " + this.getX() + " and " + this.getY();
        return objectInfo;
    }
}
