import java.util.List;

/**
 * Class that describes an employee
 */
public class Employee extends Person {
    protected String job;
    protected int experienceYears;
    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param acquaintances A List of Person objects representing the people the designer knows
     * @param job A String representing the job of the employee
     * @param years An int representing the number of years the employee has worked
     */
    public Employee(String name, String surname, int age, List<Person> acquaintances, String job, int years) {
        super(name, surname, age, acquaintances);
        this.job = job;
        this.experienceYears = years;
    }
    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param job A String representing the job of the employee
     * @param years An int representing the number of years the employee has worked
     */
    public Employee(String name, String surname, int age, String job, int years) {
        super(name, surname, age);
        this.job = job;
        this.experienceYears = years;
    }

    @Override
    public String toString() {
        return "Employee: " + this.getUniqueName() + " has worked for " + this.experienceYears + " and is a " + this.job;
    }
}
