public class SensorReading {
    private final String sensorId;
    private final double value;

    public SensorReading(String sensorId, double value) {
        this.sensorId = sensorId;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String toString() {
        return sensorId + " -> " + value;
    }
}
