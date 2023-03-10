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
     * @param job A String representing the job of the employee
     * @param years An int representing the number of years the employee has worked
     * @param day An int representing the day of birth
     * @param month An int representing the month of birth
     * @param year An int representing the year of birth
     */
    public Employee(String name, String surname, int age, String job, int years, int day, int month, int year) {
        super(name, surname, age, day, month, year);
        this.job = job;
        this.experienceYears = years;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return "Employee: " + this.getUniqueName() + " has worked for " + this.experienceYears + " and is a " + this.job;
    }
}
