public class SmartDeviceControl {

    public static void main(String[] args) {
        SmartDevice light = new Light();
        SmartDevice ac = new AirConditioner();
        SmartDevice tv = new Television();

        light.turnOn();
        light.turnOff();
        ac.turnOn();
        ac.turnOff();
        tv.turnOn();
        tv.turnOff();
    }
}

interface SmartDevice {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Light is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class AirConditioner implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("AC is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AC is OFF");
    }
}

class Television implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is OFF");
    }
}
