package com.coderscampus.A10.MealPlanner.dto;

public class Meal {
    private Long id;
    private String title;
    private String imageType;

    public Meal(Long id, String title, String imageType) {
        this.id = id;
        this.title = title;
        this.imageType = imageType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}

