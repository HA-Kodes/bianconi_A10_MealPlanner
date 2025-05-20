package com.coderscampus.A10.MealPlanner.dto;
import java.util.List;

public class DayResponse {

    private List<Meal> meals;
    private Nutrients nutrients;

    public DayResponse() {
    }

    public DayResponse(List<Meal> meals, Nutrients nutrients) {
        this.meals = meals;
        this.nutrients = nutrients;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }
}


