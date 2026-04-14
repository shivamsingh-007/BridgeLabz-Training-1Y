package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phoneDirectory = new LinkedHashMap<>();
        
        phoneDirectory.put("John Smith", "555-1234");
        phoneDirectory.put("Jane Doe", "555-5678");
        phoneDirectory.put("Bob Wilson", "555-9012");
        phoneDirectory.put("Alice Brown", "555-3456");
        phoneDirectory.put("Charlie Davis", "555-7890");
        
        System.out.println("Phone Directory:");
        for (Map.Entry<String, String> entry : phoneDirectory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\nSearch for 'Jane Doe': " + phoneDirectory.get("Jane Doe"));
        
        phoneDirectory.put("Eve Miller", "555-1111");
        phoneDirectory.put("David Lee", "555-2222");
        
        System.out.println("\nAfter adding 2 contacts:");
        phoneDirectory.forEach((name, phone) -> System.out.println(name + ": " + phone));
        
        System.out.println("\nTotal Contacts: " + phoneDirectory.size());
        
        String searchName = "Bob Wilson";
        if (phoneDirectory.containsKey(searchName)) {
            System.out.println(searchName + "'s number: " + phoneDirectory.get(searchName));
        }
        
        phoneDirectory.remove("Charlie Davis");
        System.out.println("\nAfter removing Charlie Davis: " + phoneDirectory.size() + " contacts");
    }
}
