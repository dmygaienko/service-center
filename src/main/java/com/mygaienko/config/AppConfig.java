package com.mygaienko.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by enda1n on 09.11.2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.mygaienko.controller", "com.mygaienko.service", "com.mygaienko.service.security", "com.mygaienko.dao"})
@EntityScan(basePackages = {"com.mygaienko.model"})
@Import({WebSecurityConfig.class, MethodSecurityConfig.class})
public class AppConfig {
}
