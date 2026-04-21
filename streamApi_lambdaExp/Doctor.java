public class Doctor {
    private final String name;
    private final String specialty;
    private final boolean weekendAvailable;

    public Doctor(String name, String specialty, boolean weekendAvailable) {
        this.name = name;
        this.specialty = specialty;
        this.weekendAvailable = weekendAvailable;
    }

    public boolean isWeekendAvailable() {
        return weekendAvailable;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String toString() {
        return name + " | " + specialty + " | weekendAvailable=" + weekendAvailable;
    }
}
