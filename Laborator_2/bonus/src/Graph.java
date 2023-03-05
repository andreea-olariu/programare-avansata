import java.util.*;

/**
 * Class that manipulates the data as a graph
 *
 * @author andreeaolariu
 */
public class Graph {
    private ArrayList<Location> nodes;
    private ArrayList<Integer> ids;
    private int[][] costMatrix;

    /**
     * Default constructor
     */
    Graph() {
        nodes = new ArrayList<Location>();
        ids = new ArrayList<Integer>();
    }

    /**
     * Constructor that takes as argument two ArrayLists and uses them:
     * <li>Location objects from _locations ArrayList are the nodes of the Graph and each of them has an unique id </li>
     * <li>Road objects from _roads ArrayList represent the edges of the graph and the costMatrix of this object stores the length of the road as a cost</li>
     *
     * @param _locations An ArrayList of Location objects
     * @param _roads     An ArrayList of Road objects
     */
    Graph(ArrayList<Location> _locations, ArrayList<Road> _roads) {
        this();
        int index = 0;
        for (Location loc : _locations) {
            if (!nodes.contains(loc)) {
                nodes.add(loc);
                ids.add(index++);
            }
        }

        costMatrix = new int[nodes.size()][nodes.size()];
        for(int[] line : costMatrix) {
            Arrays.fill(line, Integer.MAX_VALUE);
        }

        for (Road road : _roads) {
            int loc1Index = nodes.indexOf(road.getLoc1());
            int loc2Index = nodes.indexOf(road.getLoc2());
            costMatrix[loc1Index][loc2Index] = road.getLength();
            costMatrix[loc2Index][loc1Index] = road.getLength();
        }
    }

    /**
     * Compute the shortest path between two given Location objects using Dijkstra's algorithm
     * @param loc1 A Location object representing the first location
     * @param loc2 A Location object representing the second location
     * @return A BestRouteSolution object representing data about the shortest path
     */
    public BestRouteSolution shortestPath(Location loc1, Location loc2) {
        BestRouteSolution bestRouteSolution = new BestRouteSolution();
        HashSet<Location> visited = new HashSet<Location>();
        HashMap<Location, Integer> costs = new HashMap<Location, Integer>();
        HashMap<Location, Location> before = new HashMap<Location, Location>();

        visited.add(loc1);
        costs.put(loc1, 0);
        before.put(loc1, null);

        while(visited.size() != this.nodes.size()) {
            Location locMinim = null;
            Location locBefore = null;

            int minim = Integer.MAX_VALUE;
            for (Location loc : visited) {

                int index = this.nodes.indexOf(loc);
                for (int i = 0; i < this.nodes.size(); i++) {
                    if ((costs.get(loc) + costMatrix[index][i]) < minim && !visited.contains(this.nodes.get(i)) &&
                            costMatrix[index][i] != Integer.MAX_VALUE) {
                        minim = costs.get(loc) + costMatrix[index][i];
                        locMinim = this.nodes.get(i);
                        locBefore = loc;
                    }
                }
            }

            before.put(locMinim, locBefore);
            visited.add(locMinim);
            costs.put(locMinim, minim);

        }

        int length = Integer.MAX_VALUE;
        if(costs.get(loc2) != null)
            length = costs.get(loc2);

        Location tmp = loc2;
        while(tmp != null) {
            bestRouteSolution.addLocation(tmp);
            tmp = before.get(tmp);
        }

        bestRouteSolution.setLength(length);
        return bestRouteSolution;
    }
}
