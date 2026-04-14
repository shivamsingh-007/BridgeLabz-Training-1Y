package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> studentMarks = new HashMap<>();
        
        studentMarks.put("Alice", new HashMap<>() {{
            put("Math", 85);
            put("Science", 92);
            put("English", 78);
            put("History", 88);
        }});
        
        studentMarks.put("Bob", new HashMap<>() {{
            put("Math", 95);
            put("Science", 88);
            put("English", 91);
            put("History", 84);
        }});
        
        studentMarks.put("Charlie", new HashMap<>() {{
            put("Math", 72);
            put("Science", 68);
            put("English", 75);
            put("History", 70);
        }});
        
        System.out.println("Student Subject Marks:");
        for (Map.Entry<String, Map<String, Integer>> student : studentMarks.entrySet()) {
            System.out.println("\n" + student.getKey() + ":");
            for (Map.Entry<String, Integer> subject : student.getValue().entrySet()) {
                System.out.println("  " + subject.getKey() + ": " + subject.getValue());
            }
        }
        
        System.out.println("\nAverage Marks per Student:");
        studentMarks.forEach((student, subjects) -> {
            double average = subjects.values().stream().mapToInt(Integer::intValue).average().orElse(0);
            System.out.println(student + ": " + String.format("%.2f", average));
        });
        
        System.out.println("\nHighest Marks per Subject:");
        Set<String> subjects = new HashSet<>();
        studentMarks.values().forEach(m -> subjects.addAll(m.keySet()));
        subjects.forEach(subject -> {
            int maxMark = studentMarks.values().stream()
                .mapToInt(m -> m.getOrDefault(subject, 0))
                .max().orElse(0);
            String topStudent = studentMarks.entrySet().stream()
                .filter(e -> e.getValue().getOrDefault(subject, 0) == maxMark)
                .map(Map.Entry::getKey).findFirst().orElse("");
            System.out.println(subject + ": " + maxMark + " (" + topStudent + ")");
        });
        
        studentMarks.get("Alice").put("Math", 90);
        System.out.println("\nUpdated Alice's Math marks to 90");
    }
}
