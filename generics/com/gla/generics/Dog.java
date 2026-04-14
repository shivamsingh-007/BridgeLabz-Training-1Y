package com.gla.generics;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public String bark() {
        return getName() + " says Woof!";
    }

    @Override
    public String toString() {
        return "Dog: " + getName();
    }
}
