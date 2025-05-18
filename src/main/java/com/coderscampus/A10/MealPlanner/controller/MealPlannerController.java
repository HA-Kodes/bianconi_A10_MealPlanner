package com.coderscampus.A10.MealPlanner.controller;

import com.coderscampus.A10.MealPlanner.config.SpoonacularConfig;  // handles configuration for meal planning
import com.coderscampus.A10.MealPlanner.model.DayResponse;         // stores meal plan results
import com.coderscampus.A10.MealPlanner.model.WeekResponse;        // store meal plan results
import org.springframework.http.ResponseEntity;                    // helps format API responses
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;                // used for making API calls (like asking a website for data)

@RequestMapping("/api") // This tells the program that all URLs starting with /api are handled here
@RestController         // This means it's a controller that handles web requests and returns responses
public class MealPlannerController { // This is our class that controls meal planning requests
    // create and define variables
    private SpoonacularConfig spoon; // spoon is where we get meal data
    private RestTemplate rest;       // rest helps send and receive data from the internet

    // create a Constructor
    public MealPlannerController(SpoonacularConfig spoon, RestTemplate rest) { // constructor
        this.spoon = spoon; // runs when a MealPlannerController is created
        this.rest = rest;   // sets the values of spoon and rest by pulling data from SpoonaclarConfig class
    }

    // Setting up an API Endpoint
    @GetMapping("/mealplanner/week")   // this tells the program: "When someone visits /api/mealplanner/week, run the next function."

    // make a function (copy from A10 desc) ad define the Meal Plan Function
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {  // this function fetches meal plans based on:
        String url = buildUrl("week", numCalories, diet, exclusions);                            // numCalories, diet, exclusions (ingredients to avoid)
        WeekResponse response = rest.getForObject(url, WeekResponse.class);
        return ResponseEntity.ok(response);                                                                 // it builds a URL, sends it to Spoonacular's API, and returns meal plan data
    }

    // Setting up an API Endpoint
    @GetMapping("/mealplanner/day")   // this tells the program: "When someone visits /api/mealplanner/week, run the next function."

    // make a function (copy from A10 desc) ad define the Meal Plan Function
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {  // this function fetches meal plans based on:
        String url = buildUrl("day", numCalories, diet, exclusions);                            // numCalories, diet, exclusions (ingredients to avoid)
        DayResponse response = rest.getForObject(url, DayResponse.class);
        return ResponseEntity.ok(response);                                                                 // it builds a URL, sends it to Spoonacular's API, and returns meal plan data
    }

    // Build the URL for API Calls
    private String buildUrl(String timeFrame, String numCalories, String diet, String exclusions) {
        StringBuilder url = new StringBuilder(spoon.getMealPlanUrl())   // StringBuilder url builds a web address (URL) to request meal plans
                .append("?timeFrame=").append(timeFrame)                // this calls from the function; it starts with Spoonacular's base URL and addon timeFrame ("week")
                .append("&apiKey=").append(spoon.getApiKey());          // this calls from SpoonacularConfig.java; it starts with Spoonacular's base URL and addon apiKey

        if (numCalories != null) {                                      // these if statements ck if values exist, and add them to the URL:
            url.append("&targetCalories=").append(numCalories);         // Calories (&targetCalories=_
        }
        if (diet != null) {
            url.append("&diet=").append(diet);                          // Diet type (&diet=)
        }
        if (exclusions != null) {
            url.append("&exclude=").append(exclusions);                 // Exclude foods (&exclude=)
        }
        return url.toString();                                          // returns the complete URL
    }
}
