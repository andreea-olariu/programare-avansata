/**
 * Interface that defines an user in the network
 */
public interface Node {
    /**
     * Gets an unique identifier for the user
     * @return A String representing an unique identifier for the user
     */
    public String getUniqueName();

    /**
     * Checks if two users are the same
     * @param n A Node object representing the object this is compared to
     * @return <li>true if the two objects are equal</li><li>false otherwise</li>
     */
    public boolean equalsTo(Node n);

    /**
     * Compute the importance of the Node in network
     * @return An int representing the importance of the Node in network
     */
    default public int computeImportance() {
        return 0;
    }

    /**
     * Compares two Node objects by their importance
     * @param n1 A Node object
     * @param n2 A Node object
     * @return An int representing the difference of the importance between the second Node and the first Node
     */
    public static int compareNodes(Node n1, Node n2) {
        return n2.computeImportance() - n1.computeImportance();
    }

}
