package com.sg.mealsspringbootrest.dao.mappers;

import com.sg.mealsspringbootrest.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int index) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setName(rs.getString("name"));
        return user;
    }
}