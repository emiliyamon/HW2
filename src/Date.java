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

    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYea(year);
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


    @Override
    public int hashCode() {
        int hashCode;
        return hashCode;
    }


    @Override
    public boolean equals(Date date) {
        if (this == date) {
            return true;
        }
        if () {
            return false;
        }

    }

}
