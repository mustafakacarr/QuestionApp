package com.project.questionapp.controllers;

import com.project.questionapp.entities.User;
import com.project.questionapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable long userId){
        //Custom exception hazırlanacak.
        return userService.findUserById(userId);
    }
    @PutMapping(path = "/{userId}")
    public User updateUser(@PathVariable long userId,@RequestBody User newUser){
        //Custom exception hazırlanacak.
      return userService.updateUser(userId,newUser);
    }
    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable long userId){
        userService.deleteUserById(userId);
    }

}
