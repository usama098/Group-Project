package com.sg.mealsspringbootrest.dao;
import com.sg.mealsspringbootrest.model.Meal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import com.sg.mealsspringbootrest.dao.MealDaoImpl;
import com.sg.mealsspringbootrest.model.Meal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

import com.sg.mealsspringbootrest.dao.MealDaoImpl;
import com.sg.mealsspringbootrest.model.Meal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/*
class MealDaoImplTest {

    @Test
    void addMeal() {
    }

    @Test
    void getAllMeals() {
    }

    @Test
    void findMealById() {
    }

    @Test
    void updateMeal() {
    }

    @Test
    void deleteMealById() {
    }
}*/



    @DataJdbcTest
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    public class MealDaoImplTest {

        private JdbcTemplate jdbcTemplate;
        private MealDaoImpl mealDaoImpl;

        @Autowired
        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
            mealDaoImpl = new MealDaoImpl(jdbcTemplate);
        }

        @Test
        @DisplayName("Add Meal Test")
        public void addMealTest() {
            Meal meal = new Meal();
            meal.setMeal_title("Test Meal");
            meal.setMeal_items("Test Items");
            meal.setCalories(100);
            meal.setProtein(10);
            meal.setSugar(5);
            meal.setFat(15);
            meal.setSalt(2);
            meal.setUserId(1);

            Meal addedMeal = mealDaoImpl.addMeal(meal);

            assertNotNull(addedMeal);
            assertNotNull(addedMeal.getMealId());
            assertEquals("Test Meal", addedMeal.getMeal_title());
        }

        @Test
        @DisplayName("Get All Meals Test")
        public void getAllMealsTest() {
            List<Meal> meals = mealDaoImpl.getAllMeals();

            assertNotNull(meals);
            assertEquals(1, meals.size()); // Assuming there are initially 3 meals in the database
        }

        @Test
        @DisplayName("Find Meal By Id Test")
        public void findMealByIdTest() {
            Meal meal = mealDaoImpl.findMealById(2);

            assertNotNull(meal);
            assertEquals(2, meal.getMealId());
        }

        @Test
        @DisplayName("Update Meal Test")
        public void updateMealTest() {
            Meal meal = mealDaoImpl.findMealById(1);
            meal.setMeal_title("Updated Title");
            meal.setMeal_items("Updated Items");
            meal.setCalories(200);
            meal.setProtein(20);
            meal.setSugar(10);
            meal.setFat(30);
            meal.setSalt(5);

            mealDaoImpl.updateMeal(meal);

            Meal updatedMeal = mealDaoImpl.findMealById(1);

            assertNotNull(updatedMeal);
            assertEquals("Updated Title", updatedMeal.getMeal_title());
            assertEquals("Updated Items", updatedMeal.getMeal_items());
            assertEquals(200, updatedMeal.getCalories());
        }

        @Test
        @DisplayName("Delete Meal By Id Test")
        public void deleteMealByIdTest() {
            mealDaoImpl.deleteMealById(2);
            Meal deletedMeal = mealDaoImpl.findMealById(2);
            assertEquals(null, deletedMeal);
        }
    }

