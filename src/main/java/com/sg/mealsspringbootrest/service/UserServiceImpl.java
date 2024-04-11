package com.sg.mealsspringbootrest.service;


import com.sg.mealsspringbootrest.dao.UserDao;
import com.sg.mealsspringbootrest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public User addNewUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User updateUserData(int id, User user) {
        userDao.updateUser(user);
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}
