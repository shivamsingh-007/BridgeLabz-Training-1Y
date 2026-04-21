import java.util.Arrays;
import java.util.List;

public class IoTSensorReadings {

    public static void main(String[] args) {
        List<SensorReading> readings = Arrays.asList(
                new SensorReading("S1", 34.5),
                new SensorReading("S2", 48.2),
                new SensorReading("S3", 26.8),
                new SensorReading("S4", 51.9)
        );

        double threshold = 40.0;
        readings.stream().filter(reading -> reading.getValue() > threshold).forEach(System.out::println);
    }
}
