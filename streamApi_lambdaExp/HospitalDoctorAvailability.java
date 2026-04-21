import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HospitalDoctorAvailability {

    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Rao", "Cardiology", true),
                new Doctor("Dr. Iyer", "Neurology", false),
                new Doctor("Dr. Khan", "Orthopedics", true),
                new Doctor("Dr. Sen", "Dermatology", true)
        );

        doctors.stream()
                .filter(Doctor::isWeekendAvailable)
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                .forEach(System.out::println);
    }
}
