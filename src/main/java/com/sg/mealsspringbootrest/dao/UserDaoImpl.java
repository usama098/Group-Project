package com.sg.mealsspringbootrest.dao;

import com.sg.mealsspringbootrest.dao.mappers.UserMapper;
import com.sg.mealsspringbootrest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User addUser(User user) {
        final String sql = "INSERT INTO user(name) VALUES(?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getName());
            return statement;

        }, keyHolder);

        user.setUserId(keyHolder.getKey().intValue());

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        final String sql = "SELECT * from user;";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public User findUserById(int userId) {
        final String sql = "SELECT * "
                + "FROM user WHERE userId = ?;";

        return jdbcTemplate.queryForObject(sql, new UserMapper(), userId);
    }

    @Override
    public void updateUser(User user) {
        final String sql = "UPDATE user SET name = ? WHERE userId = ?;";

        jdbcTemplate.update(sql,
                user.getName(),
                user.getUserId());
    }

    @Override
    public void deleteUserById(int userId) {
        final String sql = "DELETE FROM user WHERE userId = ?;";
        jdbcTemplate.update(sql, userId);
    }
}
