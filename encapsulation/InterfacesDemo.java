public class InterfacesDemo {

    public static void main(String[] args) {
        Flyable bird = new Bird();
        Swimmable fish = new Fish();
        Flyable plane = new Airplane();

        bird.fly();
        fish.swim();
        plane.fly();

        Duck duck = new Duck();
        duck.fly();
        duck.swim();
    }
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird flaps wings to fly");
    }
}

class Fish implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Fish swims with fins");
    }
}

class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane uses engines to fly");
    }
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck flies with wings");
    }

    @Override
    public void swim() {
        System.out.println("Duck paddles in water");
    }
}
