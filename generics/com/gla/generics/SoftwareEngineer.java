package com.gla.generics;

public class SoftwareEngineer implements JobRole {
    private String name;
    private int experienceYears;
    private String[] requiredSkills;

    public SoftwareEngineer(String name, int experienceYears, String[] requiredSkills) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.requiredSkills = requiredSkills;
    }

    public String getName() {
        return name;
    }

    public String getRoleName() {
        return "Software Engineer";
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }

    @Override
    public String toString() {
        StringBuilder skills = new StringBuilder();
        for (int i = 0; i < requiredSkills.length; i++) {
            skills.append(requiredSkills[i]);
            if (i < requiredSkills.length - 1) {
                skills.append(", ");
            }
        }
        return "Software Engineer: " + name + " - " + experienceYears + " years exp - Skills: " + skills;
    }
}
