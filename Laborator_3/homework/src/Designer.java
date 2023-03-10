import java.util.List;

/**
 * Class that describes a designer employee
 */
public class Designer extends Employee {
    private int designingYears;
    private String designingStyle;

    /**
     * Constructor
     * @param name A String representing the name of the person
     * @param surname A String representing the surname of the person
     * @param age An int representing the age of the person
     * @param years An int representing the number of years the employee has worked
     * @param designingYears An int representing the number of years the designer has worked as a designer
     * @param day An int representing the day of birth
     * @param month An int representing the month of birth
     * @param year An int representing the year of birth
     * @param designingStyle A String representing the designing style of the person
     */
    public Designer(String name, String surname, int age, int years, int designingYears, int day, int month, int year, String designingStyle) {
        super(name, surname, age, "Designer", years, day, month, year);
        this.designingYears = designingYears;
        this.designingStyle = designingStyle;
    }

    public int getDesigningYears() {
        return designingYears;
    }

    public void setDesigningYears(int designingYears) {
        this.designingYears = designingYears;
    }

    public String getDesigningStyle() {
        return designingStyle;
    }

    public void setDesigningStyle(String designingStyle) {
        this.designingStyle = designingStyle;
    }

    @Override
    public String toString() {
        return "Designer: " + this.getUniqueName() + " has worked for " + this.experienceYears +
                " and has worked as a designer for " + this.designingYears;
    }
}
