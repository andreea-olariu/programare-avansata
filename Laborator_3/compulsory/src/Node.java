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
}
