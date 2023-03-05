import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Location loc1 = new Location("Iasi", "City", 100, 200);
        Location loc2 = new Location("Bucuresti", "City", 123, 154);
        Location loc3 = new Location("Vaslui", "City", 313, 332);
        Location loc4 = new Location("Brasov", "City", 203, 303);
        Location loc5 = new Location("Henri Coanda", "Airport", 122, 323);

        Road road1;
        Road road2;
        Road road3;
        Road road4;
        Road road5;
        Road road6;

        try {
            road1 = new Road("Highway", 115039, (float) 13.2, loc1, loc2);
            road2 = new Road("Highway", 120800, (float) 13.2, loc1, loc3);
            road3 = new Road("Highway", 145534, (float) 13.2, loc2, loc4);
            road4 = new Road("Highway", 132123, (float) 13.2, loc3, loc5);
            road5 = new Road("Highway", 132334, (float) 13.2, loc1, loc5);
            road6 = new Road("Highway", 232823, (float) 13.2, loc4, loc5);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ArrayList<Location> locs = new ArrayList<Location>();
        locs.add(loc1);
        locs.add(loc2);
        locs.add(loc3);
        locs.add(loc4);
        locs.add(loc5);

        ArrayList<Road> roads = new ArrayList<Road>();
        roads.add(road1);
        roads.add(road2);
        roads.add(road3);
        roads.add(road4);
        roads.add(road5);
        roads.add(road6);

        Graph graph = new Graph(locs, roads);

        long start = System.currentTimeMillis();
        BestRouteSolution bestRouteSolution = graph.shortestPath(loc1, loc5);
        System.out.println("The best route is: " + bestRouteSolution);
        long end = System.currentTimeMillis();
        System.out.println("Running time: " + (end - start) + " milliseconds");

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory consumption " + memory + " bytes");

    }
}