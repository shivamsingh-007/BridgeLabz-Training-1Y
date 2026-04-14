package com.gla.generics;

import java.util.List;

public class AnimalHierarchy {
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<Animal> animalList = new java.util.ArrayList<>();
        animalList.add(new Animal("Generic Animal"));
        printAnimals(animalList);

        java.util.ArrayList<Dog> dogList = new java.util.ArrayList<>();
        dogList.add(new Dog("Buddy"));
        dogList.add(new Dog("Max"));
        printAnimals(dogList);

        java.util.ArrayList<Cat> catList = new java.util.ArrayList<>();
        catList.add(new Cat("Whiskers"));
        catList.add(new Cat("Tom"));
        printAnimals(catList);
    }
}
