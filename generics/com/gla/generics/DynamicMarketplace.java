package com.gla.generics;

public class DynamicMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 49.99, new BookCategory("Technology"));
        System.out.println("Original: " + book);
        book.applyDiscount(20);
        System.out.println("After 20% discount: " + book);
        System.out.println("Discounted price for 15%: $" + book.getDiscountedPrice(15));

        System.out.println();

        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 35.00, new ClothingCategory("L"));
        System.out.println("Original: " + shirt);
        shirt.applyDiscount(10);
        System.out.println("After 10% discount: " + shirt);
        System.out.println("Discounted price for 25%: $" + shirt.getDiscountedPrice(25));

        System.out.println();

        Product<ClothingCategory> pants = new Product<>("Denim Jeans", 55.00, new ClothingCategory("32"));
        System.out.println("Original: " + pants);
        pants.applyDiscount(30);
        System.out.println("After 30% discount: " + pants);
    }
}
