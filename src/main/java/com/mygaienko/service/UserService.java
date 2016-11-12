package com.mygaienko.service;

import com.mygaienko.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 12.11.2016.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


}
