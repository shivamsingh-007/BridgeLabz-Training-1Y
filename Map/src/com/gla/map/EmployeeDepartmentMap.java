package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> employeeDepartments = new HashMap<>();
        
        employeeDepartments.put("Engineering", new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie")));
        employeeDepartments.put("Marketing", new ArrayList<>(Arrays.asList("Diana", "Eve")));
        employeeDepartments.put("Sales", new ArrayList<>(Arrays.asList("Frank", "Grace", "Henry")));
        employeeDepartments.put("HR", new ArrayList<>(Arrays.asList("Ivy")));
        
        System.out.println("Employee Department Mapping:");
        for (Map.Entry<String, List<String>> entry : employeeDepartments.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        employeeDepartments.get("Engineering").add("Jack");
        System.out.println("\nAdded Jack to Engineering: " + employeeDepartments.get("Engineering"));
        
        employeeDepartments.put("IT", new ArrayList<>(Arrays.asList("Kevin", "Laura")));
        System.out.println("\nAdded IT Department: " + employeeDepartments.get("IT"));
        
        System.out.println("\nDepartments with more than 2 employees:");
        employeeDepartments.forEach((dept, employees) -> {
            if (employees.size() > 2) {
                System.out.println(dept + ": " + employees.size() + " employees");
            }
        });
        
        int totalEmployees = employeeDepartments.values().stream().mapToInt(List::size).sum();
        System.out.println("\nTotal Employees: " + totalEmployees);
        System.out.println("Total Departments: " + employeeDepartments.size());
        
        employeeDepartments.remove("HR");
        System.out.println("\nAfter removing HR: " + employeeDepartments.size() + " departments");
    }
}
