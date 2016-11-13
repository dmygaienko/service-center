package com.mygaienko.service;

import com.mygaienko.dao.UserDao;
import com.mygaienko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enda1n on 12.11.2016.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public List<User> findByFirstName(String firstName) {
        return userDao.getByFirstName(firstName);
    }
}
