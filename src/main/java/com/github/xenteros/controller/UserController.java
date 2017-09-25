package com.github.xenteros.controller;

import com.github.xenteros.model.User;
import com.github.xenteros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by agurgul on 25.09.2017.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }
}
