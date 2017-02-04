package com.mygaienko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by enda1n on 09.11.2016.
 */
@Configuration
@Import({ServiceConfig.class, WebSecurityConfig.class, MethodSecurityConfig.class, CacheConfig.class})
public class AppConfig {
}
