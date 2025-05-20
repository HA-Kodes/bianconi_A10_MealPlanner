package com.coderscampus.A10.MealPlanner.service;

import com.coderscampus.A10.MealPlanner.config.SpoonacularConfig;
import com.coderscampus.A10.MealPlanner.dto.WeekResponse;
import com.coderscampus.A10.MealPlanner.dto.DayResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

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
        String url = buildApiUrl("week", numCalories, diet, exclusions);
        WeekResponse response = rest.getForObject(url, WeekResponse.class);
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        String url = buildApiUrl("day", numCalories, diet, exclusions);
        DayResponse response = rest.getForObject(url, DayResponse.class);
        return ResponseEntity.ok(response);
    }

    // UriComponentsBuilder
     private String buildApiUrl(String timeFrame, String calories, String diet, String exclusions) {
        return UriComponentsBuilder.fromHttpUrl(spoon.getMealPlanUrl())
            .queryParam("timeFrame", timeFrame)
            .queryParam("apiKey", spoon.getApiKey())
            .queryParamIfPresent("targetCalories", Optional.ofNullable(calories))
            .queryParamIfPresent("diet", Optional.ofNullable(diet))
            .queryParamIfPresent("exclude", Optional.ofNullable(exclusions))
            .build()
            .toUriString();
    }
}
