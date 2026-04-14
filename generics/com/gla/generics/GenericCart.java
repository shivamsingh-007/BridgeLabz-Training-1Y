package com.gla.generics;

public class GenericCart {
    public static void main(String[] args) {
        Cart<String> electronicsCart = new Cart<>();
        electronicsCart.addItem("Laptop");
        electronicsCart.addItem("Smartphone");
        electronicsCart.addItem("Headphones");
        System.out.println("Electronics Cart:");
        electronicsCart.displayItems();
        electronicsCart.removeItem("Smartphone");
        System.out.println("After removing Smartphone:");
        electronicsCart.displayItems();

        System.out.println();

        Cart<String> clothingCart = new Cart<>();
        clothingCart.addItem("T-Shirt");
        clothingCart.addItem("Jeans");
        clothingCart.addItem("Jacket");
        System.out.println("Clothing Cart:");
        clothingCart.displayItems();
        clothingCart.removeItem("Jeans");
        System.out.println("After removing Jeans:");
        clothingCart.displayItems();
    }
}
