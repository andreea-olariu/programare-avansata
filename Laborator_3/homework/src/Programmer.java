import java.util.List;

/**
 * Class that describes a programmer employee
 */
public class Programmer extends Employee {
    private int programmingYears;
    private String programmingLanguage;
    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param years An int representing the number of years the employee has worked
     * @param programmingYears An int representing the number of years the programmer has worked as a programmer
     * @param day An int representing the day of birth
     * @param month An int representing the month of birth
     * @param year An int representing the year of birth
     * @param programmingLanguage A String representing the programming language the programmer works with
     */
    public Programmer(String name, String surname, int age, int years, int programmingYears, int day, int month, int year, String programmingLanguage) {
        super(name, surname, age, "Programmer", years, day, month, year);
        this.programmingYears = programmingYears;
        this.programmingLanguage = programmingLanguage;
    }

    public int getProgrammingYears() {
        return programmingYears;
    }

    public void setProgrammingYears(int programmingYears) {
        this.programmingYears = programmingYears;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Programmer: " + this.getUniqueName() + " has worked for " + this.experienceYears +
                " and has worked as a programmer for " + this.programmingYears;
    }
}
