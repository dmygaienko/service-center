package com.mygaienko.controller;

import com.mygaienko.model.User;
import com.mygaienko.model.dto.UserInfo;
import com.mygaienko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by enda1n on 12.11.2016.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/me", method = RequestMethod.POST)
    public UserInfo user(Authentication authentication) {
        return new UserInfo(authentication);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @RequestMapping(value = "/find/byFirstName/{firstName}", method = RequestMethod.GET)
    public List<User> findByFirstName(@PathVariable("firstName") String firstName) {
        return userService.findByFirstName(firstName);
    }

}
