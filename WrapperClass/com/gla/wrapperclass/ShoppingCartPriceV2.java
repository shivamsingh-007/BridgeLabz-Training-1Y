package com.gla.wrapperclass;

import java.util.ArrayList;

public class ShoppingCartPriceV2 {
    public static void main(String[] args) {
        String[] itemNames = {"Shirt", "Shoes", "Belt", "Hat", "Socks"};
        String[] itemPrices = {"799", "1499", "xyz", "349", "99"};

        ArrayList<Integer> validPrices = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < itemPrices.length; i++) {
            try {
                int price = Integer.parseInt(itemPrices[i]);
                validPrices.add(price);
                total += price;
                System.out.println(itemNames[i] + ": " + price);
            } catch (NumberFormatException e) {
                System.out.println(itemNames[i] + ": Invalid price \"" + itemPrices[i] + "\" - skipped");
            }
        }

        System.out.println("----------------------------");
        System.out.println("Total Cart Price: " + total);
    }
}
