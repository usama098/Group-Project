package com.sg.mealsspringbootrest.service;


import com.sg.mealsspringbootrest.dao.MealDao;
import com.sg.mealsspringbootrest.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealServiceImpl implements MealServiceInterface {

    @Autowired
    MealDao mealDao;

    public MealServiceImpl(MealDao mealDao){
        this.mealDao = mealDao;
    }

    @Override
    public List<Meal> getAllMeals() {
        return mealDao.getAllMeals();
    }

    @Override
    public Meal getMealById(int id) {
        return mealDao.findMealById(id);
    }

    @Override
    public Meal addNewMeal(Meal meal) {
        return mealDao.addMeal(meal);
    }

    @Override
    public Meal updateMealData(int id, Meal meal) {
        if (meal.getMealId() != id){
            meal.setMeal_title("IDs do not match, meal not updated");
        } else {
            mealDao.updateMeal(meal);
        }
        return meal;
    }

    @Override
    public void deleteMealById(int id) {
        mealDao.deleteMealById(id);

    }
}