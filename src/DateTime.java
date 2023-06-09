public class DateTime extends Date {
    private static final int HOUR_MIN_VALUE = 0;
    private static final int MINUTE_MIN_VALUE = 0;
    private static final int HOUR_MAX_VALUE = 23;
    private static final int MINUTE_MAX_VALUE = 59;
    private static final int MINUTE_DEFAULT_VALUE = 0;
    private static final int HOUR_DEFAULT_VALUE = 0;
    private int hour;
    private int minute;


    public DateTime(int day, int month, int year, int hour, int minute) {
        super(day, month, year);
        setHour(hour);
        setMinute(minute);
    }
    public int getMinute() {
        return minute;
    }
    public int getHour() {
        return hour;
    }
    public boolean inRange(int num, int lowerBound, int upperBound) {
        return (num >= lowerBound && num <= upperBound);
    }
    public void setMinute(int minute) {
        if (!inRange(minute, MINUTE_MIN_VALUE, MINUTE_MAX_VALUE)) {
            this.minute = MINUTE_DEFAULT_VALUE; //=0
        } else {
            this.minute = minute;
        }
    }
    public void setHour(int hour) {
        if (!inRange(hour, HOUR_MIN_VALUE, HOUR_MAX_VALUE)) {
            this.hour = HOUR_DEFAULT_VALUE; //=0
        } else {
            this.hour = hour;
        }
    }

    /**
     * Indicates whether another object is equal to current object
     *
     * @param other the referenced object with which to compare
     * @return boolean true or false according to the result of the method testing
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DateTime)) {
            return false;
        }
        super.equals(other); //maybe need to add a variable
        DateTime otherDateTime = (DateTime) other;
        return (this.minute == otherDateTime.minute && this.hour == otherDateTime.hour);
    }
    /**
     * Returns a hash code value for the object based on the number of minutes passed from midnight.
     *
     * @return a hash value for the object
     */
    @Override
    public int hashCode() {
        return minute + 60 * hour;
    }
    @Override
    public String toString(){
       String DayMonthYearString = super.toString();
       minute = getMinute();
       hour = getHour();
       String minuteString;
       String hourString;
        if (minute < 10) {
            minuteString = "0" + minute;
        } else {
            minuteString = Integer.toString(minute);
        }
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = Integer.toString(hour);
        }
       return DayMonthYearString + " " + hourString + ":" + minuteString;
    }

}
