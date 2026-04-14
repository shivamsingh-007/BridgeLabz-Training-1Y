package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Patient> patients = new LinkedHashMap<>();
        
        patients.put("P001", new Patient("P001", "John Smith", 45, "Flu", "General Ward"));
        patients.put("P002", new Patient("P002", "Jane Doe", 32, "Broken Arm", "Emergency"));
        patients.put("P003", new Patient("P003", "Bob Wilson", 58, "Heart Condition", "ICU"));
        patients.put("P004", new Patient("P004", "Alice Brown", 27, "Appendicitis", "Surgery"));
        patients.put("P005", new Patient("P005", "Charlie Davis", 71, "Diabetes", "General Ward"));
        
        System.out.println("Hospital Patients:");
        for (Map.Entry<String, Patient> entry : patients.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        System.out.println("\nPatient P003 Details: " + patients.get("P003"));
        
        System.out.println("\nPatients by Ward:");
        Map<String, List<String>> patientsByWard = new HashMap<>();
        patients.forEach((id, patient) -> {
            patientsByWard.computeIfAbsent(patient.getWard(), k -> new ArrayList<>()).add(patient.getName());
        });
        patientsByWard.forEach((ward, names) -> {
            System.out.println(ward + ": " + names);
        });
        
        System.out.println("\nPatients above 50 years:");
        patients.forEach((id, patient) -> {
            if (patient.getAge() > 50) {
                System.out.println(patient.getName() + " (" + patient.getAge() + ")");
            }
        });
        
        patients.put("P006", new Patient("P006", "Diana Evans", 38, "Pneumonia", "ICU"));
        System.out.println("\nAdmitted Diana Evans. Total patients: " + patients.size());
        
        patients.remove("P002");
        System.out.println("Discharged Jane Doe. Remaining patients: " + patients.size());
        
        patients.get("P005").updateCondition("Diabetes (Controlled)");
        System.out.println("\nUpdated Charlie Davis condition: " + patients.get("P005").getCondition());
    }
}

class Patient {
    private String patientId;
    private String name;
    private int age;
    private String condition;
    private String ward;
    
    public Patient(String patientId, String name, int age, String condition, String ward) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.condition = condition;
        this.ward = ward;
    }
    
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCondition() { return condition; }
    public String getWard() { return ward; }
    
    public void updateCondition(String condition) {
        this.condition = condition;
    }
    
    @Override
    public String toString() {
        return name + " | Age: " + age + " | Condition: " + condition + " | Ward: " + ward;
    }
}
