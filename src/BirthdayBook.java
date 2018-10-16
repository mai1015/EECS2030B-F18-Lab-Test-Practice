public class BirthdayBook {

    private Entry list[];
    private int noc;
    private final static int MAX_ENTRIES = 10;

    public BirthdayBook() {
        list = new Entry[MAX_ENTRIES];
    }

    public int getNumberOfEntries() {return noc; }

    public Entry[] getEntries() {
        return list;
////        Entry[] copy = new Entry[noc];
//        for (int i = 0; i < noc; i++) {
//            copy[i] = list[i];
//        }
//        return copy;
    }

    public void addEntry(String name, Birthday birthday) {
        int i = indexOf(name);
        if (i == -1)
            list[noc++] = new Entry(name, birthday);
        else
            list[i].setBirthday(birthday);
    }

    public void addEntry(String name, int month, int day) {
        addEntry(name, new Birthday(month, day));
    }

    public void removeEntry(String name) {
        int index = indexOf(name);
        if (index == -1) return;
        noc--;
        for (int i = index; i < noc; i++) {
            list[i] = list[i + 1];
        }
    }

    public Entry getEntry(String name) {
        int i = indexOf(name);
        return i == -1 ? null : list[i];
    }

    public int indexOf(String name) {
        for (int i = 0; i < noc; i++) {
            if (list[i].getName().equals(name))
                return i;
        }
        return -1;
    }

    public boolean nameExists(String name) {
        return !(getEntry(name) == null);
    }

    public Birthday getBirthday(String name) {
        Entry entry = getEntry(name);
        return entry == null ? null : entry.getBirthday();
    }

    public String[] getReminders(Birthday birthday) {
        int same[] = new int[noc];
        int size = 0;
        for (int i = 0; i < noc; i++) {
            if (list[i].getBirthday().equals(birthday))
                same[size++] = i;
        }

        String reminder[] = new String[size];
        for (int i = 0; i < size; i++) {
            reminder[i] = list[same[i]].getName();
        }
        return reminder;

    }

    public String[] getReminders(int month, int day) {
        Birthday b = new Birthday(month, day);
        return getReminders(b);
    }

    @Override
    public String toString() {
        StringBuilder all = new StringBuilder();
        all.append(String.format("There are %d entries in the book\n", noc));
        for (int i = 0; i < noc; i++) {
            all.append(list[i].toString());
            all.append("\n");
        }
        return all.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BirthdayBook) {
            BirthdayBook other = (BirthdayBook) obj;
            if (noc != other.noc) return false;
            for (int i = 0; i < noc; i++) {
                if (!list[i].equals(other.list[i]))
                    return false;
            }
        }
        return false;
    }
}
