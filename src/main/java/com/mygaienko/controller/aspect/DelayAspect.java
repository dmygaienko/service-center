package com.mygaienko.controller.aspect;

/**
 * Created by enda1n on 26.11.2016.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/*
*   Transaction Management
    Logging
    Exception Handling (especially when you may want to have detailed traces or have some plan of recovering from exceptions)
    Security aspects
    Instrumentation
* */

@Aspect
@Component
public class DelayAspect {

    @Before("execution(* com.mygaienko.controller.*Controller.*(..))")
    public void sleep(JoinPoint joinpoint) throws InterruptedException {
        Thread.sleep(155);
    }

}
