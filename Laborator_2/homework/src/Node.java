/**
 * Class that represents a node of a Linked List
 */
public class Node {
    private Location value;
    private Node next;

    /**
     * Constructor
     * @param value  A Location objects representing the value of the Node
     * @param next A Node object representing the next Node in the Linked List after the current one
     */
    public Node(Location value, Node next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Gets the value of the Node
     * @return A Location object representing the value of the Node
     */
    public Location getValue() {
        return value;
    }

    /**
     * Sets the value of the Node
     * @param value A Location object representing the value of the Node
     */
    public void setValue(Location value) {
        this.value = value;
    }

    /**
     * Gets the next Node in the Linked List after the current one
     * @return A Node object representing the next Node in the Linked List after the current one
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next Node in the Linked List after the current one
     * @param next A Node object representing the next value in the Linked List
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
