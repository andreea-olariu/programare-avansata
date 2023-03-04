import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that manipulates the data as a graph
 * @author andreeaolariu
 */
public class Graph {
    private ArrayList<Location> nodes;
    private ArrayList<LinkedList> adjLists;

    /**
     * Default constructor
     */
    Graph() {
        nodes = new ArrayList<Location>();
        adjLists = new ArrayList<LinkedList>();
    }

    /**
     * Constructor that takes as argument two ArrayLists and uses them:
     * <li>Location objects from _locations ArrayList are the nodes of the Graph and for each of them it initializes a LinkedList</li>
     * <li>Road objects from _roads ArrayList represent the edges of the graph and every road is added to the adjacency list</li>
     * @param _locations An ArrayList of Location objects
     * @param _roads An ArrayList of Road objects
     */
    Graph(ArrayList<Location> _locations, ArrayList<Road> _roads) {
        this();

        for(Location loc : _locations) {
            if(!nodes.contains(loc)) {
                nodes.add(loc);

                LinkedList list = new LinkedList(loc, (Node) null, null);
                adjLists.add(list);

            }
        }

        for(Road road : _roads) {
            // first loc
            LinkedList list = this.getLinkedListForNode(road.getLoc1());
            if(list != null) {
                list.addNode(road.getLoc2());
            }
            // second loc
            list = this.getLinkedListForNode(road.getLoc2());
            if(list != null) {
                list.addNode(road.getLoc1());
            }
        }
    }

    /**
     * Gets the adjacency list for a Location object given as an argument
     * @param loc A Location Object
     * @return The adjacency list corresponding to loc
     */
    public LinkedList getLinkedListForNode(Location loc) {
        if(this.adjLists == null) return null;
        for(LinkedList list : this.adjLists) {
            if(loc.equals(list.getIndex()))
                return list;
        }
        return null;
    }

    /**
     * Checks if two Location objects are connected using a DFS algorithm
     * @param start The first Location object
     * @param end The second Location object
     * @return <li>true if there is a road between the two Location objects</li><li>false if there isn't</li>
     */
    public boolean checkIfConnected(Location start, Location end) {
        Stack<Location> stack = new Stack<Location>();
        ArrayList<Location> visited = new ArrayList<Location>();
        stack.add(start);
        while(!stack.empty()) {
            Location top = stack.pop();
            visited.add(top);
            if(top.equals(end))
                return true;

            LinkedList list = this.getLinkedListForNode(top);
            if(list == null) continue;

            Node node = list.getStart();
            while(node != null) {
                if(!visited.contains(node.getValue())) {
                    stack.add(node.getValue());
                }
                node = node.getNext();
            }
        }
        return false;
    }
}
