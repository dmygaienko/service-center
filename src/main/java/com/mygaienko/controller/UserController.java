package com.mygaienko.controller;

import com.mygaienko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enda1n on 12.11.2016.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


}
