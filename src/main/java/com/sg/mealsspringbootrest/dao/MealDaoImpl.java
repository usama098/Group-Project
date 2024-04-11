package com.sg.mealsspringbootrest.dao;

import com.sg.mealsspringbootrest.dao.mappers.MealMapper;
import com.sg.mealsspringbootrest.model.Meal;
import com.sg.mealsspringbootrest.service.MealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

//import javax.transaction.Transactional;

import java.sql.*;
import java.util.List;

@Repository
public class MealDaoImpl implements MealDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public MealDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Meal addMeal(Meal meal) {

        final String sql = "INSERT INTO meal(meal_items, meal_title, calories, protein, sugar, fat, salt, userId) VALUES(?,?,?,?,?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, meal.getMeal_items());
            statement.setString(2, meal.getMeal_title());
            statement.setDouble(3, meal.getCalories());
            statement.setDouble(4, meal.getProtein());
            statement.setDouble(5, meal.getSugar());
            statement.setDouble(6, meal.getFat());
            statement.setDouble(7, meal.getSalt());
            statement.setDouble(8, meal.getUserId());
            return statement;

        }, keyHolder);

        meal.setMealId(keyHolder.getKey().intValue());

        return meal;
    }

    @Override
    public List<Meal> getAllMeals() {
        final String sql = "SELECT * from meal;";
        return jdbcTemplate.query(sql, new MealMapper());
    }

    @Override
    public Meal findMealById(int mealId) {
        final String sql = "SELECT * "
                + "FROM meal WHERE mealId = ?;";

        return jdbcTemplate.queryForObject(sql, new MealMapper(), mealId);
    }

    @Override
    public void updateMeal(Meal meal) {
        final String sql = "UPDATE meal SET "
                + "meal_items = ?, "
                + "meal_title = ?, "
                + "calories = ?"
                + "protein = ?,"
                + "sugar = ?,"
                + "fat = ?,"
                + "salt = ?,"
                + "userId = ?,"
                + "WHERE mealId = ?;";

        jdbcTemplate.update(sql,
                meal.getMeal_items(),
                meal.getMeal_title(),
                meal.getCalories(),
                meal.getProtein(),
                meal.getSugar(),
                meal.getFat(),
                meal.getSalt(),
                meal.getUserId(),
                meal.getMealId());
    }

    @Override
    public void deleteMealById(int mealId) {
        final String sql = "DELETE FROM meal WHERE mealId = ?;";
        jdbcTemplate.update(sql, mealId);
    }
}
