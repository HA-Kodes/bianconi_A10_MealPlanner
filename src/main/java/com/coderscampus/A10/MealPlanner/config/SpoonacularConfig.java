package com.coderscampus.A10.MealPlanner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpoonacularConfig {
    @Value("${spoonacular.api.key}")
    private String apiKey;
    @Value("${spoonacular.urls.base}")
    private String baseUrl;
    @Value("${spoonacular.urls.mealplan}")
    private String mealPlanPath;
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public String getApiKey() {
        return apiKey;
    }
    public String getMealPlanUrl() {
        return baseUrl + mealPlanPath;
    }
    public String getMealPlanPath() {
        return mealPlanPath;
    }
}
