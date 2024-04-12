package com.sg.mealsspringbootrest.dao;

import java.util.List;

import com.sg.mealsspringbootrest.model.User;

public interface UserDao {

    User addUser(User user) ;

    List<User> getAllUsers() ;

    User findUserById(int userId);

    // true if item exists and is updated
    void updateUser(User user);

    // true if item exists and is deleted
    void deleteUserById(int userId);

}
