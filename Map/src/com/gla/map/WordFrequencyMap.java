package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "java is a programming language java is object oriented " +
                      "programming with java you can develop applications";
        
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> wordFrequency = new LinkedHashMap<>();
        
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        String mostFrequent = Collections.max(wordFrequency.entrySet(), 
            Comparator.comparingInt(Map.Entry::getValue)).getKey();
        System.out.println("\nMost Frequent Word: " + mostFrequent + 
                          " (appears " + wordFrequency.get(mostFrequent) + " times)");
        
        System.out.println("\nWords appearing more than once:");
        wordFrequency.forEach((word, count) -> {
            if (count > 1) {
                System.out.println(word + ": " + count);
            }
        });
        
        int totalWords = wordFrequency.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nTotal Words: " + totalWords);
        System.out.println("Unique Words: " + wordFrequency.size());
    }
}
