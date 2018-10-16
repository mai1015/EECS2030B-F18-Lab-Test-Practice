public class Birthday {

    public final static String months[] = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"};
    public final static int days[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int month;
    private int day;

    public Birthday(int month, int day) {
        if (!validateDate(month, day)) throw new IllegalArgumentException();
        this.month = month;
        this.day = day;
    }

    public boolean validateDate(int month, int day) {
        return (0 < month && month < 13) && (0 < day && day <= days[month - 1]);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%s %d", months[month - 1], day);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Birthday) {
            return ((Birthday)obj).day == day && ((Birthday)obj).month == month;
        }
        return false;
    }
}
