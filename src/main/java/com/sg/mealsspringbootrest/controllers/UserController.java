package com.sg.mealsspringbootrest.controllers;

import com.sg.mealsspringbootrest.model.Meal;
import com.sg.mealsspringbootrest.model.User;
import com.sg.mealsspringbootrest.service.MealServiceImpl;
import com.sg.mealsspringbootrest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userServiceImpl.addNewUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId){
        return userServiceImpl.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user){
        return userServiceImpl.updateUserData(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userServiceImpl.deleteUserById(userId);
    }

}