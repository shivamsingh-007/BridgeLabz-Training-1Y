package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> movieRatings = new TreeMap<>();
        
        movieRatings.put("The Shawshank Redemption", 9.3);
        movieRatings.put("The Godfather", 9.2);
        movieRatings.put("The Dark Knight", 9.0);
        movieRatings.put("Pulp Fiction", 8.9);
        movieRatings.put("Forrest Gump", 8.8);
        movieRatings.put("Inception", 8.8);
        movieRatings.put("The Matrix", 8.7);
        movieRatings.put("Goodfellas", 8.7);
        
        System.out.println("Movie Ratings (Sorted by Title):");
        for (Map.Entry<String, Double> entry : movieRatings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        List<Map.Entry<String, Double>> sortedByRating = new ArrayList<>(movieRatings.entrySet());
        sortedByRating.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
        
        System.out.println("\nTop 5 Highest Rated Movies:");
        for (int i = 0; i < 5 && i < sortedByRating.size(); i++) {
            Map.Entry<String, Double> entry = sortedByRating.get(i);
            System.out.println((i+1) + ". " + entry.getKey() + ": " + entry.getValue());
        }
        
        double averageRating = movieRatings.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println("\nAverage Rating: " + String.format("%.2f", averageRating));
        
        double highestRating = Collections.max(movieRatings.values());
        String topMovie = movieRatings.entrySet().stream()
            .filter(e -> e.getValue() == highestRating)
            .map(Map.Entry::getKey).findFirst().orElse("");
        System.out.println("Highest Rated: " + topMovie + " (" + highestRating + ")");
        
        movieRatings.put("Interstellar", 8.6);
        System.out.println("\nAdded Interstellar. Total movies: " + movieRatings.size());
        
        movieRatings.remove("Inception");
        System.out.println("After removing Inception: " + movieRatings.size() + " movies");
    }
}
