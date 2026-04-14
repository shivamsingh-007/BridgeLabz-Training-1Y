package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> countryCapital = new LinkedHashMap<>();
        
        countryCapital.put("United States", "Washington D.C.");
        countryCapital.put("United Kingdom", "London");
        countryCapital.put("France", "Paris");
        countryCapital.put("Germany", "Berlin");
        countryCapital.put("Japan", "Tokyo");
        countryCapital.put("China", "Beijing");
        countryCapital.put("India", "New Delhi");
        countryCapital.put("Australia", "Canberra");
        countryCapital.put("Canada", "Ottawa");
        countryCapital.put("Brazil", "Brasilia");
        
        System.out.println("Country-Capital Map:");
        for (Map.Entry<String, String> entry : countryCapital.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        System.out.println("\nSearch for 'Japan': " + countryCapital.get("Japan"));
        
        System.out.println("\nCountries starting with 'U':");
        countryCapital.forEach((country, capital) -> {
            if (country.startsWith("U")) {
                System.out.println(country + ": " + capital);
            }
        });
        
        countryCapital.put("Italy", "Rome");
        countryCapital.put("Spain", "Madrid");
        System.out.println("\nAdded Italy and Spain. Total: " + countryCapital.size() + " countries");
        
        if (countryCapital.containsKey("Germany")) {
            countryCapital.put("Germany", "Berlin (Updated)");
            System.out.println("Updated Germany's capital");
        }
        
        countryCapital.remove("Australia");
        System.out.println("After removing Australia: " + countryCapital.size() + " countries");
        
        System.out.println("\nAll Capitals:");
        countryCapital.values().forEach(System.out::println);
    }
}
