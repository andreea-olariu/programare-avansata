import java.util.ArrayList;

/**
 * This class is used for storing information about a location.
 * @author andreeaolariu
 *
 */

public class Location {
    private String name;
    private String type;
    private float x;
    private float y;

    /**
     * Creates a new Location object
     * @param name A String representing the name of the location
     * @param t A LocationType representing the type of the location
     * @param x An int representing the x coordinate of the location
     * @param y An int representing the y coordinate of the location
     */
    Location(String name, String type, int x, int y) {
        if(!type.equals("City") && !type.equals("Airport") && !type.equals("Gas station")) {
            System.out.println("The type of the Location " + name + " is invalid!");
        } else {
            this.type = type;
        }
        this.name = name;
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
     * @return A String representing the type of the location
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the location
     * @param type A String representing the type of the location
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the String format of the object
     * @return A string representing information
     * about the object
     */

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Checks if two locations are the same
     * @param obj A Location object
     * @return <ul>A boolean value: <li><strong>true</strong> if the locations are the same</li> <li><strong>false</strong> if the locations are different</li></ul>
     */
    @Override
    public boolean equals(Object obj) {
        return this.toString().compareTo(obj.toString()) == 0;
    }
}
