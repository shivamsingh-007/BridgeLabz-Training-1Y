package com.gla.collectionframework;

import java.util.*;

public class CourierDelivery {
    private PriorityQueue<Parcel> urgentParcels;
    private Set<String> deliveredParcelIds;
    private List<Parcel> allParcels;
    private Queue<Parcel> regularDelivery;

    public CourierDelivery() {
        this.urgentParcels = new PriorityQueue<>(Comparator.comparingInt(Parcel::getUrgency).reversed());
        this.deliveredParcelIds = new HashSet<>();
        this.allParcels = new ArrayList<>();
        this.regularDelivery = new LinkedList<>();
    }

    public void addParcel(Parcel parcel) {
        allParcels.add(parcel);
        if (parcel.getUrgency() > 3) {
            urgentParcels.offer(parcel);
        } else {
            regularDelivery.offer(parcel);
        }
    }

    public void deliverParcel() {
        Parcel parcel = urgentParcels.poll();
        if (parcel == null) {
            parcel = regularDelivery.poll();
        }
        if (parcel != null) {
            parcel.deliver();
            deliveredParcelIds.add(parcel.getParcelId());
        }
    }

    public void rerouteParcel(String parcelId) {
        System.out.println("Rerouting: " + parcelId);
    }

    public List<Parcel> getParcelsByDestination(String destination) {
        List<Parcel> destParcels = new ArrayList<>();
        for (Parcel p : allParcels) {
            if (p.getDestination().equals(destination)) {
                destParcels.add(p);
            }
        }
        return destParcels;
    }

    public Set<String> getDeliveredParcelIds() {
        return deliveredParcelIds;
    }

    public int getPendingCount() {
        return urgentParcels.size() + regularDelivery.size();
    }

    public static void main(String[] args) {
        CourierDelivery courier = new CourierDelivery();
        courier.addParcel(new Parcel("C001", "Chicago", 5));
        courier.addParcel(new Parcel("C002", "Boston", 2));
        courier.addParcel(new Parcel("C003", "Chicago", 4));
        System.out.println("Pending: " + courier.getPendingCount());
        courier.deliverParcel();
        courier.deliverParcel();
        System.out.println("Delivered: " + courier.getDeliveredParcelIds());
        System.out.println("Chicago parcels: " + courier.getParcelsByDestination("Chicago"));
    }
}

class Parcel {
    private String parcelId;
    private String destination;
    private int urgency;

    public Parcel(String parcelId, String destination, int urgency) {
        this.parcelId = parcelId;
        this.destination = destination;
        this.urgency = urgency;
    }

    public void deliver() {
        System.out.println("Delivering parcel " + parcelId + " to " + destination);
    }

    public String getParcelId() { return parcelId; }
    public String getDestination() { return destination; }
    public int getUrgency() { return urgency; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Objects.equals(parcelId, parcel.parcelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcelId);
    }
}
