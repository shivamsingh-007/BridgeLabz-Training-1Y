import java.util.Random;

class SupportTicket extends Thread {
    int ticketNumber;
    String ticketType;
    int ticketPriority;
    static long totalWaitTime = 0;
    static int ticketCount = 0;

    SupportTicket(int ticketNumber, String ticketType, int ticketPriority) {
        this.ticketNumber = ticketNumber;
        this.ticketType = ticketType;
        this.ticketPriority = ticketPriority;
        this.setPriority(ticketPriority);
        this.setName("Agent-" + ticketNumber);
    }

    public void run() {
        Random random = new Random();
        int processingTime = (random.nextInt(5) + 1);

        System.out.println("Ticket #" + ticketNumber + " | Type: " + ticketType +
                " | Agent: " + getName() + " | Priority: " + ticketPriority + " | Processing STARTED");

        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(processingTime * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Ticket #" + ticketNumber + " interrupted.");
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = (endTime - startTime) / 1000;

        synchronized (SupportTicket.class) {
            totalWaitTime += timeTaken;
            ticketCount++;
        }

        System.out.println("Ticket #" + ticketNumber + " | Type: " + ticketType +
                " | Agent: " + getName() + " | Processing COMPLETED in " + timeTaken + " seconds");
    }
}

public class CustomerSupportSystem {
    public static void main(String[] args) throws InterruptedException {
        SupportTicket[] tickets = {
            new SupportTicket(1, "Critical Bug", 10),
            new SupportTicket(2, "General Query", 2),
            new SupportTicket(3, "Critical Bug", 10),
            new SupportTicket(4, "Feature Request", 4),
            new SupportTicket(5, "Feedback", 1),
            new SupportTicket(6, "Critical Bug", 10),
            new SupportTicket(7, "General Query", 2),
            new SupportTicket(8, "Feature Request", 4),
            new SupportTicket(9, "Feedback", 1),
            new SupportTicket(10, "General Query", 2)
        };

        System.out.println("===== Customer Support Ticketing System =====");
        for (SupportTicket ticket : tickets) {
            System.out.println("Queued: Ticket #" + ticket.ticketNumber + " | Type: " + ticket.ticketType + " | Priority: " + ticket.ticketPriority);
        }
        System.out.println("=============================================");

        for (SupportTicket ticket : tickets) {
            ticket.start();
        }

        for (SupportTicket ticket : tickets) {
            ticket.join();
        }

        System.out.println("\n===== STATISTICS =====");
        System.out.println("Total Tickets Processed: " + SupportTicket.ticketCount);
        System.out.println("Average Processing Time: " + (SupportTicket.totalWaitTime / SupportTicket.ticketCount) + " seconds");
        System.out.println("======================");
    }
}
