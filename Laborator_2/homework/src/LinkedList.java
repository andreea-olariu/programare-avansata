/**
 * Class that represent the Linked List data structure
 * @author andreeaolariu
 */

public class LinkedList {
    private Location index;
    private Node start;
    private Node end;

    /**
     * Default constructor
     */
    public LinkedList() {
        start = null;
        end = null;
    }

    /**
     * Constructor
     * @param index A Location object
     * @param start A Node object representing the start of the Linked List
     * @param end A Node object representing the end of the Linked List
     */
    public LinkedList(Location index, Node start, Node end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor
     * @param index A Location object
     * @param start A Location object representing the value of the start Node of the Linked List
     * @param end A Location object representing the value of the end Node of the Linked List
     */

    public LinkedList(Location index, Location start, Location end) {
        this.index = index;
        this.start = new Node(start, null);
        this.end = new Node(end, null);
    }

    /**
     * Adds a new Node to the end of the Linked List
     * @param newNode A Node objects to be added to the Linked List
     */
    public void addNode(Node newNode) {
        if(this.end != null) {
            this.end.setNext(newNode);
        } else {
            this.start = newNode;
        }
        this.end = newNode;
    }

    /**
     * Adds a new Node to the end of the Linked List
     * @param newLocation A Location objects representing the value of the Node to be added to the Linked List
     */
    public void addNode(Location newLocation) {
        Node newNode = new Node(newLocation, null);
        if(this.end != null) {
            this.end.setNext(newNode);
            this.end = newNode;
        }
        else {
            this.start = newNode;
            this.end = newNode;
        }
    }

    /**
     * Gets the index of the Linked List
     * @return a Location objects representing the index of the Linked List
     */
    public Location getIndex() {
        return index;
    }

    /**
     * Sets the index of the Linked List
     * @param index A Location object representing the new index of the Linked List
     */
    public void setIndex(Location index) {
        this.index = index;
    }

    /**
     * Gets the start Node object of the Linked List
     * @return A Node object representing the start Node of the Linked List
     */
    public Node getStart() {
        return start;
    }

    /**
     * Sets the start Node of the Linked List
     * @param start A Node object representing the new start of the Linked List
     */
    public void setStart(Node start) {
        this.start = start;
    }

    /**
     * Gets the end Node of the Linked List
     * @return A Node object representing the end of the Linked List
     */
    public Node getEnd() {
        return end;
    }

    /**
     * Sets the end Node of the Linked List
     * @param end A Node object representing the end Node of the Linked List
     */
    public void setEnd(Node end) {
        this.end = end;
    }
}
