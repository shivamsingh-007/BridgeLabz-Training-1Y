class Order implements Runnable {
    int orderId;
    String restaurantName;
    int deliveryTime;
    String deliveryType;

    Order(int orderId, String restaurantName, int deliveryTime, String deliveryType) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.deliveryTime = deliveryTime;
        this.deliveryType = deliveryType;
    }

    public void run() {
        String agent = Thread.currentThread().getName();
        long start = System.currentTimeMillis();

        System.out.println("Order #" + orderId + " | Type: " + deliveryType + " | Agent: " + agent + " | Status: Picked up from " + restaurantName);
        try {
            Thread.sleep(deliveryTime * 1000L / 3);
            System.out.println("Order #" + orderId + " | Agent: " + agent + " | Status: In Transit");
            Thread.sleep(deliveryTime * 1000L / 3);
            Thread.sleep(deliveryTime * 1000L / 3);
            System.out.println("Order #" + orderId + " | Agent: " + agent + " | Status: Delivered");
        } catch (InterruptedException e) {
            System.out.println("Order #" + orderId + " was interrupted.");
        }

        long end = System.currentTimeMillis();
        System.out.println("Order #" + orderId + " | Total delivery time: " + ((end - start) / 1000) + " seconds");
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        Thread o1 = new Thread(new Order(101, "Pizza Palace", 3, "Express"), "Agent-A");
        Thread o2 = new Thread(new Order(102, "Burger Barn", 5, "Standard"), "Agent-B");
        Thread o3 = new Thread(new Order(103, "Sushi Spot", 2, "Express"), "Agent-C");
        Thread o4 = new Thread(new Order(104, "Taco Town", 6, "Economy"), "Agent-D");
        Thread o5 = new Thread(new Order(105, "Pasta Place", 4, "Standard"), "Agent-E");

        o1.setPriority(10);
        o2.setPriority(5);
        o3.setPriority(10);
        o4.setPriority(3);
        o5.setPriority(5);

        o1.start();
        o2.start();
        o3.start();
        o4.start();
        o5.start();
    }
}
