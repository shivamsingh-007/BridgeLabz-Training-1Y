package com.LogisticTracker;

public class RestCheckpoint extends Checkpoint {

    public RestCheckpoint(String checkpointId, String locationName, double distanceFromLast,
                           double expectedDuration, double actualDuration) {
        super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
    }

    @Override
    public boolean isCritical() {
        return false;
    }

    @Override
    public String getType() {
        return "RestCheckpoint";
    }

    @Override
    public double calculatePenalty() {
        if (!isDelayed()) return 0.0;
        return (actualDuration - expectedDuration) * 0.5;
    }
}
