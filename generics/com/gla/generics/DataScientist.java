package com.gla.generics;

public class DataScientist implements JobRole {
    private String name;
    private int experienceYears;
    private String[] requiredSkills;

    public DataScientist(String name, int experienceYears, String[] requiredSkills) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.requiredSkills = requiredSkills;
    }

    public String getName() {
        return name;
    }

    public String getRoleName() {
        return "Data Scientist";
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
        return "Data Scientist: " + name + " - " + experienceYears + " years exp - Skills: " + skills;
    }
}
