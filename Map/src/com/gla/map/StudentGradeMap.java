package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> grades = new TreeMap<>();
        
        grades.put("Alice", 85);
        grades.put("Bob", 92);
        grades.put("Charlie", 78);
        grades.put("Diana", 95);
        grades.put("Eve", 88);
        
        System.out.println("Student Grades (Sorted by Name):");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\nHighest Grade: " + Collections.max(grades.values()));
        System.out.println("Lowest Grade: " + Collections.min(grades.values()));
        
        double average = grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average Grade: " + average);
        
        System.out.println("\nStudents with grade >= 90:");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            if (entry.getValue() >= 90) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        
        grades.put("Frank", 71);
        System.out.println("\nAfter adding Frank: " + grades.size() + " students");
        
        if (grades.containsKey("Bob")) {
            grades.put("Bob", 95);
            System.out.println("Updated Bob's grade to 95");
        }
    }
}
