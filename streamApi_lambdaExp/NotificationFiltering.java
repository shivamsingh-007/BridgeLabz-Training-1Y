import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NotificationFiltering {

    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
                new Alert("A1", "critical", "Heart rate abnormal"),
                new Alert("A2", "medication", "Medicine reminder"),
                new Alert("A3", "routine", "Appointment tomorrow"),
                new Alert("A4", "critical", "Blood pressure high")
        );

        Predicate<Alert> preference = alert -> "critical".equals(alert.getType()) || "medication".equals(alert.getType());
        alerts.stream().filter(preference).forEach(System.out::println);
    }
}
