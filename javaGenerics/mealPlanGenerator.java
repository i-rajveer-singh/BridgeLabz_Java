package generics;
/*
 * NutriMealPlanner showcases a personalized meal plan generator using generics.
 * It supports multiple meal categories like Vegetarian, Vegan, Keto, and High-Protein.
 * Bounded type parameters enforce valid meal plans, while generic methods
 * dynamically validate and generate customized plans.
 */

import java.util.*;

// Base interface for all meal plans
interface MealPlan {
    // Returns meal type
    String getMealType();

    // Returns meal details
    String getDetails();
}

// Vegetarian meal subtype
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }

    public String getDetails() {
        return "Vegetarian Meal: Paneer, Brown Rice, Salad";
    }
}

// Vegan meal subtype
class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public String getDetails() {
        return "Vegan Meal: Quinoa, Chickpeas, Roasted Vegetables";
    }
}

// Keto meal subtype
class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }

    public String getDetails() {
        return "Keto Meal: Grilled Chicken, Avocado, Cheese";
    }
}

// High-protein meal subtype
class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }

    public String getDetails() {
        return "High-Protein Meal: Eggs, Lentils, Greek Yogurt";
    }
}

// Generic Meal class restricted to MealPlan types
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    // Returns the stored meal plan
    public T getMealPlan() {
        return mealPlan;
    }

    // Provides formatted meal info
    public String getMealInfo() {
        return mealPlan.getDetails();
    }
}

// Utility class for generating meals
class MealGenerator {

    // Generic method to validate and generate a meal dynamically
    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {
        Objects.requireNonNull(plan); // Prevents null meal creation
        return new Meal<>(plan);
    }

    // Displays any meal using bounded wildcard
    public static void displayMeal(Meal<? extends MealPlan> meal) {
        System.out.println(meal.getMealInfo());
    }
}

// Driver class
public class NutriMealPlanner {

    // Entry point of the program
    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal = MealGenerator.generateMeal(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealGenerator.generateMeal(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealGenerator.generateMeal(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = MealGenerator.generateMeal(new HighProteinMeal());

        System.out.println("=== Personalized Meal Plans ===");

        MealGenerator.displayMeal(vegMeal);
        MealGenerator.displayMeal(veganMeal);
        MealGenerator.displayMeal(ketoMeal);
        MealGenerator.displayMeal(proteinMeal);
    }
}
