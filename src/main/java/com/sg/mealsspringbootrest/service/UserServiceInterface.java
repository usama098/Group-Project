package com.sg.mealsspringbootrest.service;

import com.sg.mealsspringbootrest.model.User;

import java.util.List;



public interface UserServiceInterface {

    List<User> getAllUsers() throws Exception;

    User getUserById(int id) throws Exception;

    User addNewUser(User user) throws Exception;

    User updateUserData(int id, User user) throws Exception;

    void deleteUserById(int id) throws Exception;

}
