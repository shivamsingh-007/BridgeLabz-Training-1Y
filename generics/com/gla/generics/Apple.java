package com.gla.generics;

public class Apple extends Fruit {
    public Apple() {
        super("Apple");
    }

    public Apple(String variety) {
        super("Apple - " + variety);
    }
}
