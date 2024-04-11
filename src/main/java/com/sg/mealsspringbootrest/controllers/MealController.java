package com.sg.mealsspringbootrest.controllers;

import com.sg.mealsspringbootrest.dao.MealDao;
import com.sg.mealsspringbootrest.model.Meal;

import java.util.List;

import com.sg.mealsspringbootrest.service.MealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/meal")
@CrossOrigin
public class MealController {

    @Autowired
    MealServiceImpl mealServiceImpl;

    @GetMapping("/meals")
    public List<Meal> getAllMeals(){
        return mealServiceImpl.getAllMeals();
    }

    @PostMapping("/add")
    public Meal addMeal(@RequestBody Meal meal) {
        return mealServiceImpl.addNewMeal(meal);
    }

    @GetMapping("/{mealId}")
    public Meal getMealById(@PathVariable int mealId){
        return mealServiceImpl.getMealById(mealId);
    }

    @PutMapping("/{mealId}")
    public Meal updateMeal(@PathVariable int mealId, @RequestBody Meal updatedMeal) {
        return mealServiceImpl.updateMealData(mealId, updatedMeal);
    }

    @DeleteMapping("/{mealId}")
    public void deleteMeal(@PathVariable int mealId) {
        mealServiceImpl.deleteMealById(mealId);
    }
}
