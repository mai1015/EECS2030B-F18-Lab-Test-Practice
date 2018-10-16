public class Entry {
    private String name;
    private Birthday birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(int month, int day) {
        this.birthday.setMonth(month);
        this.birthday.setDay(day);
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public Entry(String name, int month, int day) {
        this.name = name;
        this.birthday = new Birthday(month, day);
    }

    public Entry(String name, Birthday birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s was born on %s", name, birthday.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Entry) {
            return ((Entry)obj).getName().equals(name) && ((Entry) obj).getBirthday().equals(birthday);
        }
        return false;
    }
}
