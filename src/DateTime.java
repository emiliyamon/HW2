public class DateTime extends Date {
    private static final int HOUR_MIN_VALUE = 0;
    private static final int MINUTE_MIN_VALUE = 0;
    private static final int HOUR_MAX_VALUE = 23;
    private static final int MINUTE_MAX_VALUE = 59;
    private static final int MINUTE_DEFAULT_VALUE = 0;
    private static final int HOUR_DEFAULT_VALUE = 0;
    private int hour;
    private int minute;


    public DateTime(int hour, int minute) {
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




}
