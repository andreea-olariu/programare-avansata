public class Main {
    public static void main(String[] args) throws Exception {
        Location loc1 = new Location("NC", Location.LocationType.CITY, 300, 200);
        Location loc2 = new Location("IDK", Location.LocationType.AIRPORT, 200, 30);
        Road road1 = null;
        try {
            road1 = new Road(Road.RoadType.HIGHWAY, 7000, 100, loc1, loc2);
        } catch (Exception e) {
            System.out.println("Road1.... ");
            e.printStackTrace();
        }

        System.out.println(loc1.toString());
        System.out.println(loc2.toString());
        if (road1 != null) {
            System.out.println(road1.toString());
        }
    }
}