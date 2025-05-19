# MealPlanner – Spring Boot Application

This is a Spring Boot application that generates meal plans using the Spoonacular API.

---

## 🧰 Requirements

- Java 17 or later  
- Maven 3.8 or higher  
- A valid [Spoonacular API key](https://spoonacular.com/food-api)

---

## 📁 Setup

Since the `application.properties` file is **not included** in the repository for security reasons, need to create it manually before running the application.

### Step 1: Create `application.properties`

Create the file at:
src/main/resources/application.properties


Paste the following content:

`spring.application.name=MealPlanner`

`spoonacular.api.key=PERSONAL_SPOONACULAR_API_KEY`<br>
`spoonacular.urls.base=https://api.spoonacular.com`<br>
`spoonacular.urls.mealplan=/mealplanner/generate`


### Step 2: Install Depedencies
`mvn clean install`

### Step 3: Run the Application

`mvn spring-boot:run`
