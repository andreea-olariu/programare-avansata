import java.lang.Math;

/**
 * This class is used to represent a road between two locations.
 * @author andreeaolariu
 */
public class Road {
    /**
     * Represents the type of the road
     */
    public static enum RoadType {
        HIGHWAY,
        EXPRESS,
        COUNTRY;
    }
    private float length;
    private float speedLimit;
    private RoadType roadType;
    private Location loc1;
    private Location loc2;

    /**
     * Creates a new Road object
     * @param roadType A RoadType representing the type of the road
     * @param length A float representing the length of the road
     * @param speedLimit A float representing the speed limit allowed on the road
     * @param l1 A Location object representing one of the locations the road connects
     * @param l2 A Location object representing the other location the road connects
     * @throws Exception if the length of the road is smaller that the euclidian distance between the two locations
     */
    Road(RoadType roadType, float length, float speedLimit, Location l1, Location l2) throws Exception {
        this.roadType = roadType;
        this.length = length;
        this.speedLimit = speedLimit;
        loc1 = l1;
        loc2 = l2;

        if(!this.validateLength()) {
            throw new Exception("The length of a road must be greater than the euclidian distance or equal!");
        }
    }

    /**
     * Gets the type of the road
     * @return A RoadType representing the type of the road
     */
    public RoadType getType() {
        return this.roadType;
    }

    /**
     * Sets the type of the road
     * @param type A RoadType representing the type of the road
     */
    public void setType(RoadType type) {
        this.roadType = type;
    }

    /**
     * Gets the length of the road
     * @return A float representing the length of the road
     */
    public float getLength() {
        return this.length;
    }

    /**
     * Sets the length of the road
     * @param length A float representing the length of the road
     */
    public void setLength(float length) {
        this.length = length;
    }

    /**
     * Gets the speed limit allowed on the road
     * @return A float representing the speed limit allowed on the road
     */
    public float getSpeedLimit() {
        return this.speedLimit;
    }

    /**
     * Sets the speed limit allowed on the road
     * @param speedLimit A float representing the speed limit allowed on the road
     */
    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * <p> Checks if the length of the road is valid </p>
     * <p> A valid length of the road is a length that is greater than the euclidian distance beween the two location it connects </p>
     * @return <ul>A boolean value: <li><strong>true</strong> if the length is valid</li> <li><strong>false</strong> if the length is not valid</li></ul>
     */
    public boolean validateLength() {
        double euclidDistance = Math.sqrt(Math.pow(loc1.getX() * loc1.getX() - loc2.getX() * loc2.getX(), 2) +
                Math.pow(loc1.getY() * loc1.getY() - loc2.getY() * loc2.getY(), 2));
        return !(this.length < euclidDistance);
    }

    /**
     * Gets the String format of the object
     * @return A string representing information about the object
     */
    @Override
    public String toString() {
        String objectInfo = "The ";
        switch(this.getType()) {
            case HIGHWAY:
                objectInfo += "highway ";
                break;
            case EXPRESS:
                objectInfo += "express ";
                break;
            case COUNTRY:
                objectInfo += "country ";
                break;
            default:
                break;
        }
        objectInfo += "between " + loc1.getName() + " and " + loc2.getName() + " has " + this.getLength() +  " km and has the speed limit of " + this.getSpeedLimit() + " km.";
        return objectInfo;
    }
}
