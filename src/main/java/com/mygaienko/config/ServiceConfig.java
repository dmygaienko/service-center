package com.mygaienko.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dmygaenko on 15/11/2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.mygaienko.controller", "com.mygaienko.service", "com.mygaienko.service.security", "com.mygaienko.dao"})
@EntityScan(basePackages = {"com.mygaienko.model"})
public class ServiceConfig {
}
