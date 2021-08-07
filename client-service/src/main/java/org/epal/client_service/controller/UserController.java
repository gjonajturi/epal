package org.epal.client_service.controller;

import org.epal.client_service.service.UserService;
import org.epal.commons.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userService.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User newUser) {
        return userService.save(newUser);
    }
}
