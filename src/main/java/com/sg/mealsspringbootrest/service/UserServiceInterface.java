package com.sg.mealsspringbootrest.service;

import com.sg.mealsspringbootrest.model.User;

import java.util.List;



public interface UserServiceInterface {

    List<User> getAllUsers();

    User getUserById(int id);

    User addNewUser(User user);

    User updateUserData(int id, User user);

    void deleteUserById(int id);

}
