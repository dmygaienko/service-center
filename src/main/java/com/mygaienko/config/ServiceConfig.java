package com.mygaienko.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by dmygaenko on 15/11/2016.
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = {"com.mygaienko.model"})
@EnableJpaRepositories(basePackages = {"com.mygaienko.dao"})
@ComponentScan(basePackages = {"com.mygaienko.controller", "com.mygaienko.service", "com.mygaienko.service.security", "com.mygaienko.dao"})
public class ServiceConfig {
}
