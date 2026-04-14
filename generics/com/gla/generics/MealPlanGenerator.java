package com.gla.generics;

public class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    public int getDailyCalories(int mealsPerDay) {
        return meal.getCalories() * mealsPerDay;
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal("Paneer Stir Fry", 450));
        System.out.println(vegMeal.getMeal().getMealType() + " - " + vegMeal.getMeal().getCalories() + " cal");
        System.out.println("Daily calories (3 meals): " + vegMeal.getDailyCalories(3));

        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal("Quinoa Bowl", 380, true));
        System.out.println(veganMeal.getMeal().getMealType() + " - " + veganMeal.getMeal().getCalories() + " cal");
        System.out.println("Daily calories (3 meals): " + veganMeal.getDailyCalories(3));

        Meal<VeganMeal> veganMeal2 = new Meal<>(new VeganMeal("Tofu Scramble", 320, false));
        System.out.println(veganMeal2.getMeal().getMealType() + " - " + veganMeal2.getMeal().getCalories() + " cal");
    }
}
