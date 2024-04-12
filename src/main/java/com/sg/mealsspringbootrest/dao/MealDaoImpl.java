package com.sg.mealsspringbootrest.dao;

import com.sg.mealsspringbootrest.model.Meal;
import com.sg.mealsspringbootrest.dao.mappers.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class MealDaoImpl implements MealDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MealDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Meal addMeal(Meal meal) {
        final String sql = "INSERT INTO meal(meal_items, meal_title, calories, protein, sugar, fat, salt, userId) VALUES(?,?,?,?,?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, meal.getMeal_items());
            statement.setString(2, meal.getMeal_title());
            statement.setDouble(3, meal.getCalories());
            statement.setDouble(4, meal.getProtein());
            statement.setDouble(5, meal.getSugar());
            statement.setDouble(6, meal.getFat());
            statement.setDouble(7, meal.getSalt());
            statement.setLong(8, meal.getUserId());
            return statement;
        }, keyHolder);

        meal.setMealId(keyHolder.getKey().intValue());
        return meal;
    }

    @Override
    public List<Meal> getAllMeals() {
        final String sql = "SELECT * FROM meal;";
        return jdbcTemplate.query(sql, new MealMapper());
    }


    @Override
    public List<Meal> getAllMealsByUserId(Long userId) {
        String sql = "SELECT mealId,meal_items,meal_title,calories,protein,sugar,fat,salt,userId FROM meal WHERE userId = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, mealRowMapper);
    }


    private final RowMapper<Meal> mealRowMapper = (rs, rowNum) -> {
        Meal meal = new Meal();
        meal.setMealId((int) rs.getLong("mealId"));
        meal.setMeal_items(rs.getString("meal_items"));
        meal.setMeal_title(rs.getString("meal_title"));
        meal.setCalories(rs.getInt("calories"));
        meal.setProtein(rs.getInt("protein"));
        meal.setSugar(rs.getInt("sugar"));
        meal.setFat(rs.getInt("fat"));
        meal.setSalt(rs.getInt("salt"));
        meal.setUserId((int) rs.getLong("userId"));

        return meal;
    };



    @Override
    public Meal findMealById(int mealId) {
        final String sql = "SELECT * FROM meal WHERE mealId = ?";
        return jdbcTemplate.queryForObject(sql, new MealMapper(), mealId);
    }

    @Override
    public void updateMeal(Meal meal) {
        final String sql = "UPDATE meal SET meal_items = ?, meal_title = ?, calories = ?, protein = ?, sugar = ?, fat = ?, salt = ?, userId = ? WHERE mealId = ?";
        jdbcTemplate.update(sql, meal.getMeal_items(), meal.getMeal_title(), meal.getCalories(), meal.getProtein(), meal.getSugar(), meal.getFat(), meal.getSalt(), meal.getUserId(), meal.getMealId());
    }

    @Override
    public void deleteMealById(int mealId) {
        final String sql = "DELETE FROM meal WHERE mealId = ?";
        jdbcTemplate.update(sql, mealId);
    }
}
