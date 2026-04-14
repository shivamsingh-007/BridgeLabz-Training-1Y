package com.gla.generics;

public class VeganMeal implements MealPlan {
    private String mealName;
    private int calories;
    private boolean organic;

    public VeganMeal(String mealName, int calories, boolean organic) {
        this.mealName = mealName;
        this.calories = calories;
        this.organic = organic;
    }

    public String getMealName() {
        return mealName;
    }

    public boolean isOrganic() {
        return organic;
    }

    public String getMealType() {
        return "Vegan: " + mealName + (organic ? " (Organic)" : "");
    }

    public int getCalories() {
        return calories;
    }
}
