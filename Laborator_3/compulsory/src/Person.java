import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that describes a person
 */
public class Person implements Comparable, Node {
    protected String name;
    protected String surname;
    protected int age;
    protected List<Person> acquaintances;

    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param acquaintances A List of Person objects representing the people the person knows
     */
    public Person(String name, String surname, int age, List<Person> acquaintances) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.acquaintances = acquaintances;
    }

    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     */
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.acquaintances = new ArrayList<>();
    }

    public String getUniqueName() {
        return name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Person> getAcquaintance() {
        return acquaintances;
    }

    public void setAcquaintance(List<Person> acquaintance) {
        this.acquaintances = acquaintance;
    }

    /**
     * Adds a new acquaintance
     * @param p A Person object representing a new acquaintance
     */
    public void addAcquaintance(Person p) {
        acquaintances.add(p);
    }

    @Override
    public String toString() {
        return "Person: " + this.getUniqueName();
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
