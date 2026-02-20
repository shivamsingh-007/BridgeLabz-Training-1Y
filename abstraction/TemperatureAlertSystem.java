import java.util.function.Predicate;

public class TemperatureAlertSystem {

    public static void main(String[] args) {
        double threshold = 37.5;
        Predicate<Double> isHighTemperature = temp -> temp > threshold;

        double[] temperatures = {36.5, 38.0, 37.0, 40.2, 37.5};

        for (double temp : temperatures) {
            if (isHighTemperature.test(temp)) {
                System.out.println("ALERT! Temperature " + temp + " exceeds threshold " + threshold);
            } else {
                System.out.println("Temperature " + temp + " is normal");
            }
        }
    }
}
