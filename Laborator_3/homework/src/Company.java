import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that describes a company
 */
public class Company implements Comparable, Node{
    private String name;
    private List<Employee> employees;

    /**
     * Constructor
     * @param name A String representing the name of the company
     * @param employees A List of Employee objects representing the employees
     */
    public Company(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    /**
     * Constructor
     * @param name A String representing the name of the company
     */
    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getUniqueName() {
        return name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Adds a new employee
     * @param employee An Employee object representing a new employee that needs to be added
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Computes the importance of the Company as an user in the network
     * @return An int representing the number of the employees
     */
    @Override
    public int computeImportance() {
        return this.getEmployees().size();
    }

    @Override
    public String toString() {
        return "Company: " + this.getUniqueName();
    }

    @Override
    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }

    @Override
    public boolean equalsTo(Node n) {
        return this.compareTo(n) == 0;
    }
}
