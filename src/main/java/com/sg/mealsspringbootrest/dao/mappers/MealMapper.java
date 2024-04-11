package com.sg.mealsspringbootrest.dao.mappers;

import com.sg.mealsspringbootrest.model.Meal;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MealMapper implements RowMapper<Meal> {
    @Override
    public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE
        Meal meal = new Meal();
        meal.setMealId(rs.getInt("mealId"));
        meal.setMeal_items(rs.getString("meal_items"));
        meal.setMeal_title(rs.getString("meal_title"));
        meal.setCalories(rs.getDouble("calories"));
        meal.setProtein(rs.getDouble("protein"));
        meal.setSugar(rs.getDouble("sugar"));
        meal.setFat(rs.getDouble("fat"));
        meal.setSalt(rs.getDouble("salt"));
        meal.setUserId(rs.getInt("userId"));
        return meal;
    }
}