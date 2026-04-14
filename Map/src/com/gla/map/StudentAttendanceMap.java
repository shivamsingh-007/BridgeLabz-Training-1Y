package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Boolean>> attendance = new LinkedHashMap<>();
        
        attendance.put("Monday", new ArrayList<>(Arrays.asList(true, true, false, true, true)));
        attendance.put("Tuesday", new ArrayList<>(Arrays.asList(true, true, true, true, false)));
        attendance.put("Wednesday", new ArrayList<>(Arrays.asList(true, false, true, true, true)));
        attendance.put("Thursday", new ArrayList<>(Arrays.asList(true, true, true, false, true)));
        attendance.put("Friday", new ArrayList<>(Arrays.asList(false, true, true, true, true)));
        
        System.out.println("Weekly Attendance:");
        for (Map.Entry<String, List<Boolean>> entry : attendance.entrySet()) {
            String day = entry.getKey();
            List<Boolean> records = entry.getValue();
            long presentCount = records.stream().filter(r -> r).count();
            System.out.println(day + ": " + presentCount + "/" + records.size() + " present");
        }
        
        System.out.println("\nAttendance Percentage by Day:");
        attendance.forEach((day, records) -> {
            long presentCount = records.stream().filter(r -> r).count();
            double percentage = (presentCount * 100.0) / records.size();
            System.out.println(day + ": " + String.format("%.1f%%", percentage));
        });
        
        List<String> daysAbsentMoreThanOnce = new ArrayList<>();
        attendance.forEach((day, records) -> {
            long absentCount = records.stream().filter(r -> !r).count();
            if (absentCount > 1) {
                daysAbsentMoreThanOnce.add(day);
            }
        });
        System.out.println("\nDays with more than 1 absence: " + daysAbsentMoreThanOnce);
        
        long totalPresent = attendance.values().stream().flatMap(List::stream).filter(r -> r).count();
        long totalRecords = attendance.values().stream().flatMap(List::stream).count();
        System.out.println("\nOverall Attendance: " + totalPresent + "/" + totalRecords + 
                          " (" + String.format("%.1f%%", (totalPresent * 100.0) / totalRecords) + ")");
    }
}
