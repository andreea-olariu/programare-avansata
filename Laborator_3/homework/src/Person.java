import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/**
 * Class that describes a person
 */
public class Person implements Comparable, Node {
    protected String name;
    protected String surname;
    protected int age;
    protected Map<Node, String> relationships;

    Date dateOfBirth;


    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param day An int representing the day of birth
     * @param month An int representing the month of birth
     * @param year An int representing the year of birth
     */
    public Person(String name, String surname, int age, int day, int month, int year) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        if(day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <= 2023) {
            dateOfBirth = new Date(day, month, year);
        }
        relationships = new HashMap<>();
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

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Computes the importance of the Person as an user in the network
     * @return An int representing the number of relationships the Person has
     */
    @Override
    public int computeImportance() {
        return this.getRelationships().size();
    }

    /**
     * Adds a new relationship
     * @param node A Node object representing the entity this person has a relationship with
     * @param value A String representing the kind of relationship is established between this person and the other entity
     */
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
        if(node instanceof Company) {
            ((Company) node).addEmployee((Employee) this);
        }
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
