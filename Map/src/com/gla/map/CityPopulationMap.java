package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Long> cityPopulation = new TreeMap<>();
        
        cityPopulation.put("New York", 8336817L);
        cityPopulation.put("Los Angeles", 3979576L);
        cityPopulation.put("Chicago", 2693976L);
        cityPopulation.put("Houston", 2320268L);
        cityPopulation.put("Phoenix", 1680992L);
        cityPopulation.put("Philadelphia", 1584064L);
        cityPopulation.put("San Antonio", 1547253L);
        cityPopulation.put("San Diego", 1423851L);
        
        System.out.println("City Populations (Sorted Alphabetically):");
        for (Map.Entry<String, Long> entry : cityPopulation.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.format("%,d", entry.getValue()));
        }
        
        System.out.println("\nTop 3 Most Populated Cities:");
        List<Map.Entry<String, Long>> sortedByPopulation = new ArrayList<>(cityPopulation.entrySet());
        sortedByPopulation.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));
        for (int i = 0; i < 3 && i < sortedByPopulation.size(); i++) {
            Map.Entry<String, Long> entry = sortedByPopulation.get(i);
            System.out.println((i+1) + ". " + entry.getKey() + ": " + String.format("%,d", entry.getValue()));
        }
        
        long totalPopulation = cityPopulation.values().stream().mapToLong(Long::longValue).sum();
        System.out.println("\nTotal Population: " + String.format("%,d", totalPopulation));
        
        cityPopulation.put("Dallas", 1343573L);
        System.out.println("\nAdded Dallas. Total cities: " + cityPopulation.size());
        
        cityPopulation.remove("Phoenix");
        System.out.println("After removing Phoenix: " + cityPopulation.size() + " cities");
    }
}
