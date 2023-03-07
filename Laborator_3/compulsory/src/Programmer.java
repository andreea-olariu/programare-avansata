import java.util.List;

/**
 * Class that describes a programmer employee
 */
public class Programmer extends Employee {
    private int programmingYears;
    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param acquaintances A List of Person objects representing the people the programmer knows
     * @param years An int representing the number of years the employee has worked
     * @param programmingYears An int representing the number of years the programmer has worked as a programmer
     */
    public Programmer(String name, String surname, int age, List<Person> acquaintances, int years, int programmingYears) {
        super(name, surname, age, acquaintances, "Programmer", years);
        this.programmingYears = programmingYears;
    }
    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param years An int representing the number of years the employee has worked
     * @param programmingYears An int representing the number of years the programmer has worked as a programmer
     */
    public Programmer(String name, String surname, int age, int years, int programmingYears) {
        super(name, surname, age, "Programmer", years);
        this.programmingYears = programmingYears;
    }

    @Override
    public String toString() {
        return "Programmer: " + this.getUniqueName() + " has worked for " + this.experienceYears +
                " and has worked as a programmer for " + this.programmingYears;
    }
}
