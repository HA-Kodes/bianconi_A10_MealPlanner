package com.coderscampus.A10.MealPlanner.service;

import com.coderscampus.A10.MealPlanner.config.SpoonacularConfig;
import com.coderscampus.A10.MealPlanner.model.WeekResponse;
import com.coderscampus.A10.MealPlanner.model.DayResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class MealPlannerService {
    private SpoonacularConfig spoon;
    private RestTemplate rest;

    // create a Constructor
    public MealPlannerService(SpoonacularConfig spoon, RestTemplate rest) {
        this.spoon = spoon;
        this.rest = rest;
    }

    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        String url = buildUrl("week", numCalories, diet, exclusions);
        WeekResponse response = rest.getForObject(url, WeekResponse.class);
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        String url = buildUrl("day", numCalories, diet, exclusions);
        DayResponse response = rest.getForObject(url, DayResponse.class);
        return ResponseEntity.ok(response);
    }

    // Build the URL for API Calls
    private String buildUrl(String timeFrame, String numCalories, String diet, String exclusions) {
        StringBuilder url = new StringBuilder(spoon.getMealPlanUrl())
                .append("?timeFrame=").append(timeFrame)
                .append("&apiKey=").append(spoon.getApiKey());

        if (numCalories != null) {
            url.append("&targetCalories=").append(numCalories);
        }
        if (diet != null) {
            url.append("&diet=").append(diet);
        }
        if (exclusions != null) {
            url.append("&exclude=").append(exclusions);
        }
        return url.toString();
    }
}
