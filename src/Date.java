/**
 * Represents a Date superClass, concluding day, month and year.
 */
public class Date {
    private static final int DAY_MIN_VALUE = 1;
    private static final int MONTH_MIN_VALUE = 1;
    private static final int YEAR_MIN_VALUE = -3999;
    private static final int DAY_MAX_VALUE = 31;
    private static final int MONTH_MAX_VALUE = 12;
    private static final int YEAR_MAX_VALUE = 3999;
    private static final int DAY_DEFAULT_VALUE = 1;
    private static final int MONTH_DEFAULT_VALUE = 1;
    private static final int YEAR_DEFAULT_VALUE = 0;


    private int day;
    private int month;
    private int year;

    public Date(int year, int month, int day) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }


    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Checking if the number is in defined range (between lower and upper bounds)
     *
     * @param num represents the number checked.
     * @param lowerBound represents the lower bound.
     * @param upperBound represents the higher bound.
     * @return boolean true or false according to the number range.
     */
    public boolean inRange(int num, int lowerBound, int upperBound) {
        return (num >= lowerBound && num <= upperBound);
    }


    public void setMonth(int month) {
        if (!inRange(month, MONTH_MIN_VALUE, MONTH_MAX_VALUE)) {
            this.month = MONTH_DEFAULT_VALUE;
        } else {
            this.month = month;
        }
    }


    public void setYear(int year) {
        if (!inRange(year, YEAR_MIN_VALUE, YEAR_MAX_VALUE)) {
            this.year = YEAR_DEFAULT_VALUE;
        } else {
            this.year = year;
        }
    }


    public void setDay(int day) {
        if (!inRange(day, DAY_MIN_VALUE, DAY_MAX_VALUE)) {
            this.day = DAY_DEFAULT_VALUE;
        } else {
            this.day = day;
        }
    }


    /**
     * Indicates whether another object is equal to current object
     *
     * @param other the referenced object with which to compare
     * @return boolean true or false according to the result of the method testing
     */
    // might need to add more conditions to make sure
    // variable with dynamic type Date won't equal to
    // variable with dynamic type DateTime
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Date)) {
            return false;
        }
        Date otherDate = (Date) other;
        if (this == otherDate) { //why did you add this? (84-85)
            return true;
        }
        return (this.day == otherDate.day && this.month == otherDate.month && this.year == otherDate.year && this.hashCode() == otherDate.hashCode());
    }


    /**
     * Returns a hash code value for the object based on the number of days passed/left to the date 01/01/-3999.
     *
     * @return a hash value for the object
     */
    @Override
    public int hashCode() {
        return day + 31 * month + 31 * 12 * (year + 3999);
    }

    /**
     * Formatting the date into string format.
     *
     * @return String represents the date in string format
     */
    @Override
    public String toString() {
        day = getDay();
        month = getMonth();
        year = getYear();

        String dayString;
        String monthString;
        String yearString;

        if (day < 10) {
            dayString = "0" + day;
        } else {
            dayString = Integer.toString(day);
        }

        if (month < 10) {
            monthString = "0" + month;
        } else {
            monthString = Integer.toString(month);
        }

        if (year >= 0) {
            if (year < 10) {
                yearString = "000" + year;
            } else if (year < 100) {
                yearString = "00" + year;
            } else if (year < 1000) {
                yearString = "0" + year;
            } else {
                yearString = Integer.toString(year);
            }
        } else {
            if (year > -10) {
                yearString = "-000" + -year;
            } else if (year > -100) {
                yearString = "-00" + -year;
            } else if (year > -1000) {
                yearString = "-0" + -year;
            } else {
                yearString = Integer.toString(year);
            }
        }

        return dayString + "/" + monthString + "/" + yearString;
    }

}
