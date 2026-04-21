import java.util.Arrays;
import java.util.List;

public class HospitalPatientIdPrinting {

    public static void main(String[] args) {
        List<String> patientIds = Arrays.asList("PT-1001", "PT-1002", "PT-1003", "PT-1004");
        patientIds.forEach(HospitalPatientIdPrinting::printPatientId);
    }

    private static void printPatientId(String patientId) {
        System.out.println(patientId);
    }
}
