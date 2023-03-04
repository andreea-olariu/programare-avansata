import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        City loc1 = new City("Iasi", 200, 10);
        City loc2 = new City("Bucuresti", 300, 100);
        Airport loc3 = new Airport("Henri Coanda", 2000, 109);
        Location loc4 = new Location("Buzau", "City", 2000, 109);

        Highway road1;
        Express road2;
        try {
//            Uncomment and an exception will be thrown (the distance is smaller than the euclidian distance)
//            road1 = new Highway(23, 40, loc1, loc2);
            road1 = new Highway(9384334, 40, loc1, loc2);
            road2 = new Express(200000042, 32, loc2, loc3);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        BestRouteProblem problem = new BestRouteProblem();
        problem.addLocation(loc1);
        problem.addLocation(loc2);
        problem.addLocation(loc3);

        problem.addRoute(road1);
        problem.addRoute(road2);
        problem.addRoute(road2);

        if(problem.isAnyRoad(loc1, loc4)) {
            System.out.println("There is a path between " + loc1.getName() + " and " + loc4.getName());
        } else {
            System.out.println("There isn't a path between " + loc1.getName() + " and " + loc4.getName());
        }

        if(problem.isAnyRoad(loc1, loc3)) {
            System.out.println("There is a path between " + loc1.getName() + " and " + loc3.getName());
        } else {
            System.out.println("There isn't a path between " + loc1.getName() + " and " + loc3.getName());
        }
    }
}