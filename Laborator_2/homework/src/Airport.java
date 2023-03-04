public class Airport extends Location {
    /**
     * Creates a new Airport object
     *
     * @param name A String representing the name of the airport
     * @param x    An int representing the x coordinate of the airport
     * @param y    An int representing the y coordinate of the airport
     */
    Airport(String name, int x, int y) {
        super(name, "Airport", x, y);
    }
}
