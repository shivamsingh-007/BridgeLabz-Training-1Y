package com.gla.generics;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public String meow() {
        return getName() + " says Meow!";
    }

    @Override
    public String toString() {
        return "Cat: " + getName();
    }
}
