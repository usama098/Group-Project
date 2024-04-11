package com.sg.mealsspringbootrest.model;

public class Meal {

    private int mealId;
    private String meal_title;
    private String meal_items;
    private double calories;
    private double sugar;
    private double protein;
    private double salt;
    private double fat;

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int id) {
        this.mealId = id;
    }

    public String getMeal_title() {
        return meal_title;
    }

    public void setMeal_title(String meal_title) {
        this.meal_title = meal_title;
    }

    public String getMeal_items() {
        return meal_items;
    }

    public void setMeal_items(String meal_items) {
        this.meal_items = meal_items;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getSalt() {
        return salt;
    }

    public void setSalt(double salt) {
        this.salt = salt;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }
}
