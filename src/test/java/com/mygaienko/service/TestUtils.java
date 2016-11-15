package com.mygaienko.service;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by dmygaenko on 15/11/2016.
 */
public class TestUtils {

    @Test
    public void testEncoder() throws Exception {
        System.out.println(new BCryptPasswordEncoder(16).encode("password"));

    }
}
