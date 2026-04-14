package com.gla.generics;

public class FruitBox<T extends Fruit> {
    private T fruit;

    public void addFruit(T fruit) {
        this.fruit = fruit;
    }

    public T getFruit() {
        return fruit;
    }

    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.addFruit(new Apple("Fuji"));
        System.out.println("Apple Box contains: " + appleBox.getFruit());

        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.addFruit(new Mango("Alphonso"));
        System.out.println("Mango Box contains: " + mangoBox.getFruit());

        FruitBox<Fruit> fruitBox = new FruitBox<>();
        fruitBox.addFruit(new Fruit("Generic Fruit"));
        System.out.println("Fruit Box contains: " + fruitBox.getFruit());
    }
}
