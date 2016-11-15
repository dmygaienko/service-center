package com.mygaienko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;


/* http://stackoverflow.com/questions/6632982/how-to-create-custom-methods-for-use-in-spring-security-expression-language-anno */
/**
 * Created by enda1n on 12.11.2016.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

}
