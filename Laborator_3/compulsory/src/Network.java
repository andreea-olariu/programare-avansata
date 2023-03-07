import java.util.ArrayList;
import java.util.List;

/**
 * Class describing a social network
 */
public class Network {
   private List<Node> users;

    /**
     * Default constructor
     */
    public Network() {
        this.users = new ArrayList<>();
    }

    /**
     * Constructor
     * @param users A List of Nodes object
     */
    public Network(List<Node> users) {
        this.users = users;
    }

    public List<Node> getUsers() {
        return users;
    }

    public void setUsers(List<Node> users) {
        this.users = users;
    }

    /**
     * Adds a new user in the network
     * @param user A Node objects representing the new user that needs to be added
     */
    public void addUser(Node user) {
        for(Node u : users) {
            if(u.equalsTo(user))
                return;
        }
        users.add(user);
    }

    @Override
    public String toString() {
        String result = "The network has:\n";
        for(Node user : users) {
            result += "\t" + user + "\n";
        }
        return result;
    }
}
