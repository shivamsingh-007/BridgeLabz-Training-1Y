package com.gla.collectionframework;

import java.util.*;

public class RideSharingDispatch {
    private Queue<RideRequest> pendingRides;
    private PriorityQueue<RideRequest> prioritizedRides;
    private Set<String> completedRideIds;
    private List<RideRequest> allRides;

    public RideSharingDispatch() {
        this.pendingRides = new LinkedList<>();
        this.prioritizedRides = new PriorityQueue<>(Comparator.comparingInt(RideRequest::getPriority).reversed());
        this.completedRideIds = new HashSet<>();
        this.allRides = new ArrayList<>();
    }

    public void requestRide(RideRequest request) {
        allRides.add(request);
        if (request.getPriority() > 2) {
            prioritizedRides.offer(request);
        } else {
            pendingRides.offer(request);
        }
    }

    public RideRequest dispatchRide() {
        RideRequest ride = prioritizedRides.poll();
        if (ride == null) {
            ride = pendingRides.poll();
        }
        if (ride != null) {
            ride.dispatch();
            completedRideIds.add(ride.getRideId());
        }
        return ride;
    }

    public List<RideRequest> getRidesByPassenger(String passengerId) {
        List<RideRequest> passengerRides = new ArrayList<>();
        for (RideRequest ride : allRides) {
            if (ride.getPassengerId().equals(passengerId)) {
                passengerRides.add(ride);
            }
        }
        return passengerRides;
    }

    public Set<String> getCompletedRideIds() {
        return completedRideIds;
    }

    public int getPendingCount() {
        return pendingRides.size() + prioritizedRides.size();
    }

    public static void main(String[] args) {
        RideSharingDispatch dispatch = new RideSharingDispatch();
        dispatch.requestRide(new RideRequest("R001", "P001", 3, 5.5));
        dispatch.requestRide(new RideRequest("R002", "P002", 1, 10.0));
        dispatch.requestRide(new RideRequest("R003", "P001", 5, 2.5));
        System.out.println("Pending rides: " + dispatch.getPendingCount());
        RideRequest ride = dispatch.dispatchRide();
        if (ride != null) System.out.println("Dispatched: " + ride.getRideId());
        System.out.println("Completed: " + dispatch.getCompletedRideIds());
    }
}

class RideRequest {
    private String rideId;
    private String passengerId;
    private int priority;
    private double distance;

    public RideRequest(String rideId, String passengerId, int priority, double distance) {
        this.rideId = rideId;
        this.passengerId = passengerId;
        this.priority = priority;
        this.distance = distance;
    }

    public void dispatch() {
        System.out.println("Ride " + rideId + " dispatched");
    }

    public String getRideId() { return rideId; }
    public String getPassengerId() { return passengerId; }
    public int getPriority() { return priority; }
    public double getDistance() { return distance; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideRequest that = (RideRequest) o;
        return Objects.equals(rideId, that.rideId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideId);
    }
}
