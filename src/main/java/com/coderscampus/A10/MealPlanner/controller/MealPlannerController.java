package com.coderscampus.A10.MealPlanner.controller;

import com.coderscampus.A10.MealPlanner.dto.DayResponse;
import com.coderscampus.A10.MealPlanner.dto.WeekResponse;
import com.coderscampus.A10.MealPlanner.service.MealPlannerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class MealPlannerController {

    private final MealPlannerService mealPlannerService;
    // create a Constructor
    public MealPlannerController(MealPlannerService mealPlannerService) {
        this.mealPlannerService = mealPlannerService;
    }

    // Setting up an API Endpoint
    @GetMapping("/mealplanner/week")

    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        return mealPlannerService.getWeekMeals(numCalories, diet, exclusions);
    }

    // Setting up an API Endpoint
    @GetMapping("/mealplanner/day")

    // make a function
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        return mealPlannerService.getDayMeals(numCalories, diet, exclusions);
    }
}
