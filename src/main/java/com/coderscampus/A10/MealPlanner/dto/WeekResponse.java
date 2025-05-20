package com.coderscampus.A10.MealPlanner.dto;

import java.util.Map;

public class WeekResponse {
    private Map<String, DayResponse> week;

    public WeekResponse() {
    }

    public WeekResponse(Map<String, DayResponse> week) {
        this.week = week;
    }

    public Map<String, DayResponse> getWeek() {
        return week;
    }

    public void setWeek(Map<String, DayResponse> week) {
        this.week = week;
    }
}
