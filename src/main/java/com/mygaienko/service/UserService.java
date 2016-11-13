package com.mygaienko.service;

import com.mygaienko.dao.UserDao;
import com.mygaienko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enda1n on 12.11.2016.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.createUser(user);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MASTER')")
    public List<User> findByFirstName(String firstName) {
        return userDao.getByFirstName(firstName);
    }
}
