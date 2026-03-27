import java.time.LocalTime;

class TemperatureSensor implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + LocalTime.now() + "] Temperature Sensor: Reading cycle " + i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Temperature Sensor interrupted.");
            }
        }
        System.out.println("Temperature Sensor: All cycles complete.");
    }
}

class SecurityCamera implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + LocalTime.now() + "] Security Camera: Recording cycle " + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Security Camera interrupted.");
            }
        }
        System.out.println("Security Camera: All cycles complete.");
    }
}

class LightController implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + LocalTime.now() + "] Light Controller: Adjusting cycle " + i);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Light Controller interrupted.");
            }
        }
        System.out.println("Light Controller: All cycles complete.");
    }
}

class DoorLockMonitor implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + LocalTime.now() + "] Door Lock Monitor: Checking cycle " + i);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("Door Lock Monitor interrupted.");
            }
        }
        System.out.println("Door Lock Monitor: All cycles complete.");
    }
}

public class SmartHomeAutomation {
    public static void main(String[] args) {
        Thread temp = new Thread(new TemperatureSensor(), "TemperatureThread");
        Thread cam = new Thread(new SecurityCamera(), "SecurityThread");
        Thread light = new Thread(new LightController(), "LightThread");
        Thread door = new Thread(new DoorLockMonitor(), "DoorThread");

        temp.setPriority(7);
        cam.setPriority(10);
        light.setPriority(5);
        door.setPriority(5);

        cam.start();
        temp.start();
        light.start();
        door.start();
    }
}
