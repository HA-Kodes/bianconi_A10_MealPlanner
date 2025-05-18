// create a model folder! Inside the model folder create a class called Meal!
// Inside the Meal class make three variables: Id, title, imageType!
// And make getters and setters!
//Research what getters and setters are and ask me on the wyzant chat if u have questions
//
//Also if u want me to review ur code or check if u are on the right track dont be afraid to send me a message on wyzant

package com.coderscampus.A10.MealPlanner.model; // Ensure it's inside the correct package

// POJO class definition - Declares private variables / fields        // ** ANOTHER WAY OF WRITING THIS POJO to Define Structure in data model
public class Meal {                                                   // public class Meal {
                                                                      // public Meal() {}  // Default constructor (optional, but useful)
    private Long id;                                                   // private int id;
    private String title;                                             // private String title;
    private String imageType;


    public Meal(Long id, String title, String imageType) {
        this.id = id;
        this.title = title;
        this.imageType = imageType;
    }

    // Getter is to retrieve value
    // Setter is to update value                                      // Constructor initializes variables
    // Getter for id                                                  // Constructor with parameters
    public Long getId() {                                              // public Meal(int id, String title, String imageType) {
        return id;                                                    // this.id = id;
    }                                                                 // this.title = title;
                                                                      // this.imageType = imageType;
    // Setter for id
    public void setId(Long id) {
        this.id = id;                                                 // Getters and Setters - (right click Generate...)
                                                                      // Meal meal = new Meal(1, "dinner meal", "png");
                                                                      // starters
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for imageType
    public String getImageType() {
        return imageType;
    }

    // Setter for imageType
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}

