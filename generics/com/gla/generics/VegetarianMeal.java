package com.gla.generics;

public class VegetarianMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VegetarianMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() {
        return mealName;
    }

    public String getMealType() {
        return "Vegetarian: " + mealName;
    }

    public int getCalories() {
        return calories;
    }
}
