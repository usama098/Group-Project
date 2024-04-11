package com.sg.mealsspringbootrest.dao.mappers;

import com.sg.mealsspringbootrest.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE

        return null;

        //YOUR CODE ENDS HERE
    }
}