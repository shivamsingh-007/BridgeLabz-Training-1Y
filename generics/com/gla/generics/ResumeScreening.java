package com.gla.generics;

import java.util.ArrayList;
import java.util.List;

public class Resume<T extends JobRole> {
    private T jobRole;
    private List<String> applications;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
        this.applications = new ArrayList<>();
    }

    public T getJobRole() {
        return jobRole;
    }

    public void addApplication(String company) {
        applications.add(company);
    }

    public List<String> getApplications() {
        return applications;
    }

    public static void main(String[] args) {
        SoftwareEngineer se = new SoftwareEngineer("John Doe", 3, 
            new String[]{"Java", "Spring Boot", "React", "MySQL"});
        Resume<SoftwareEngineer> seResume = new Resume<>(se);
        seResume.addApplication("Google");
        seResume.addApplication("Microsoft");
        System.out.println(seResume.getJobRole());
        System.out.println("Applied to: " + seResume.getApplications());

        DataScientist ds = new DataScientist("Jane Smith", 5, 
            new String[]{"Python", "TensorFlow", "SQL", "Statistics"});
        Resume<DataScientist> dsResume = new Resume<>(ds);
        dsResume.addApplication("Netflix");
        dsResume.addApplication("Amazon");
        dsResume.addApplication("Meta");
        System.out.println(dsResume.getJobRole());
        System.out.println("Applied to: " + dsResume.getApplications());
    }
}
