/**
 * Class that describes a date
 */
public class Date {
    protected int day;
    protected int month;
    protected int year;

    /**
     * Constructor
     * @param day An int representing the day
     * @param month An int representing the month
     * @param year An int representing the year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
