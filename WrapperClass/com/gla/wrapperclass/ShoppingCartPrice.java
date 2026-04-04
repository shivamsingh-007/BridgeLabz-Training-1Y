package com.gla.wrapperclass;

import java.util.ArrayList;

public class ShoppingCartPrice {
    public static void main(String[] args) {
        ArrayList<String> prices = new ArrayList<>();
        prices.add("250");
        prices.add("499");
        prices.add("abc");
        prices.add("99");
        prices.add("150");

        int total = 0;

        for (String price : prices) {
            try {
                int value = Integer.parseInt(price);
                total += value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price skipped: " + price);
            }
        }

        System.out.println("Total Price: " + total);
    }
}
