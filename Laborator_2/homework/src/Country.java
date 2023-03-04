public class Country extends Road{
    /**
     * Creates a new Road object
     *
     * @param length     A float representing the length of the road
     * @param speedLimit A float representing the speed limit allowed on the road
     * @param l1         A Location object representing one of the locations the road connects
     * @param l2         A Location object representing the other location the road connects
     * @throws Exception if the length of the road is smaller that the euclidian distance between the two locations
     */
    Country(float length, float speedLimit, Location l1, Location l2) throws Exception {
        super("Country", length, speedLimit, l1, l2);
    }
}
