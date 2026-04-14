package com.gla.collectionframework;

import java.util.*;

public class EventTicketReservation {
    private List<Booking> allBookings;
    private Set<String> confirmedBookingIds;
    private Queue<Booking> pendingBookings;
    private PriorityQueue<Booking> vipBookings;

    public EventTicketReservation() {
        this.allBookings = new ArrayList<>();
        this.confirmedBookingIds = new HashSet<>();
        this.pendingBookings = new LinkedList<>();
        this.vipBookings = new PriorityQueue<>(Comparator.comparingInt(Booking::getPriority).reversed());
    }

    public void createBooking(Booking booking) {
        allBookings.add(booking);
        if (booking.getPriority() > 2) {
            vipBookings.offer(booking);
        } else {
            pendingBookings.offer(booking);
        }
    }

    public void confirmBooking() {
        Booking booking = vipBookings.poll();
        if (booking == null) {
            booking = pendingBookings.poll();
        }
        if (booking != null) {
            booking.confirm();
            confirmedBookingIds.add(booking.getBookingId());
        }
    }

    public void cancelBooking(String bookingId) {
        confirmedBookingIds.remove(bookingId);
        System.out.println("Cancelled: " + bookingId);
    }

    public List<Booking> getBookingsByEvent(String eventId) {
        List<Booking> eventBookings = new ArrayList<>();
        for (Booking b : allBookings) {
            if (b.getEventId().equals(eventId)) {
                eventBookings.add(b);
            }
        }
        return eventBookings;
    }

    public Set<String> getConfirmedBookingIds() {
        return confirmedBookingIds;
    }

    public int getPendingCount() {
        return pendingBookings.size() + vipBookings.size();
    }

    public static void main(String[] args) {
        EventTicketReservation reservation = new EventTicketReservation();
        reservation.createBooking(new Booking("B001", "E001", "John", 3));
        reservation.createBooking(new Booking("B002", "E001", "Jane", 1));
        reservation.createBooking(new Booking("B003", "E002", "Bob", 5));
        System.out.println("Pending: " + reservation.getPendingCount());
        reservation.confirmBooking();
        reservation.confirmBooking();
        System.out.println("Confirmed: " + reservation.getConfirmedBookingIds());
    }
}

class Booking {
    private String bookingId;
    private String eventId;
    private String customerName;
    private int priority;

    public Booking(String bookingId, String eventId, String customerName, int priority) {
        this.bookingId = bookingId;
        this.eventId = eventId;
        this.customerName = customerName;
        this.priority = priority;
    }

    public void confirm() {
        System.out.println("Booking confirmed: " + bookingId);
    }

    public String getBookingId() { return bookingId; }
    public String getEventId() { return eventId; }
    public String getCustomerName() { return customerName; }
    public int getPriority() { return priority; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId);
    }
}
