import java.util.List;

/**
 * Class that describes a designer employee
 */
public class Designer extends Employee {
    private int designingYears;
    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param acquaintances A List of Person objects representing the people the designer knows
     * @param years An int representing the number of years the employee has worked
     * @param designingYears An int representing the number of years the designer has worked as a designer
     */
    public Designer(String name, String surname, int age, List<Person> acquaintances, int years, int designingYears) {
        super(name, surname, age, acquaintances, "Designer", years);
        this.designingYears = designingYears;
    }

    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param years An int representing the number of years the employee has worked
     * @param designingYears An int representing the number of years the designer has worked as a designer
     */
    public Designer(String name, String surname, int age, int years, int designingYears) {
        super(name, surname, age, "Designer", years);
        this.designingYears = designingYears;
    }

    @Override
    public String toString() {
        return "Designer: " + this.getUniqueName() + " has worked for " + this.experienceYears +
                " and has worked as a designer for " + this.designingYears;
    }
}
