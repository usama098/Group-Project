package com.sg.mealsspringbootrest.service;


import com.sg.mealsspringbootrest.dao.UserDao;
import com.sg.mealsspringbootrest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (DataAccessException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public User getUserById(int id) {
        try {
            return userDao.findUserById(id);
        } catch (DataAccessException e) {
            var user = new User();
            user.setName("User not found");
            return user;
        }
    }

    @Override
    public User addNewUser(User user) {
        try {
            return userDao.addUser(user);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public User updateUserData(int id, User user) {
        try{
            userDao.updateUser(user);
            return user;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
        
    }

    @Override
    public void deleteUserById(int id) {
        try {
            userDao.deleteUserById(id);
        }
        catch (DataAccessException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
