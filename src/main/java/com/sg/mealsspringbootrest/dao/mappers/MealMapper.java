package com.sg.mealsspringbootrest.dao.mappers;

import com.sg.mealsspringbootrest.model.Meal;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MealMapper implements RowMapper<Meal> {
    @Override
    public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE

        return null;

        //YOUR CODE ENDS HERE
    }
}