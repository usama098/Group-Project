package com.sg.mealsspringbootrest.dao;

import java.util.List;

import com.sg.mealsspringbootrest.model.Meal;

public interface MealDao {

    Meal addMeal(Meal meal) ;

    List<Meal> getAllMeals();
    Meal findMealById(int mealId);

    // true if item exists and is updated
    void updateMeal(Meal meal);

    // true if item exists and is deleted
    void deleteMealById(int mealId);

}
