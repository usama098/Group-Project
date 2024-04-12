package com.sg.mealsspringbootrest.service;


import com.sg.mealsspringbootrest.dao.MealDao;
import com.sg.mealsspringbootrest.dao.UserDao;
import com.sg.mealsspringbootrest.model.Meal;
import com.sg.mealsspringbootrest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MealServiceImpl implements MealServiceInterface {

    @Autowired
    MealDao mealDao;

    @Autowired
    private UserDao userDao;
    public List<Meal> getAllMealsByUserId(Long userId) {
        return mealDao.getAllMealsByUserId(userId);
    }



    public MealServiceImpl(MealDao mealDao){
        this.mealDao = mealDao;
    }

    @Override
    public List<Meal> getAllMeals() {
        return mealDao.getAllMeals();
    }

    @Override
    public Meal getMealById(int id) {
        try {
            return mealDao.findMealById(id);
        } catch (DataAccessException e) {
            var meal = new Meal();
            meal.setMeal_title("Meal not found");
            return meal;
        }
    }


    @Override
    public Meal addNewMeal(Meal meal) {
        return mealDao.addMeal(meal);
    }

//    @Override
//    public Meal updateMealData(int id, Meal meal) {
//        if (meal.getMealId() != id){
//            meal.setMeal_title("IDs do not match, meal not updated");
//        } else {
//            mealDao.updateMeal(meal);
//        }
//        return meal;
//    }

    @Override
    public Meal updateMealData(int mealId, Meal updatedMeal) {
        // Set the mealId of the updated meal object
        updatedMeal.setMealId(mealId);

        mealDao.updateMeal(updatedMeal);
        return updatedMeal;
    }

    @Override
    public void deleteMealById(int id) {
        mealDao.deleteMealById(id);

    }
}
