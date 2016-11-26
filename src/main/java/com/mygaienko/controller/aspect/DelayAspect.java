package com.mygaienko.controller.aspect;

/**
 * Created by enda1n on 26.11.2016.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DelayAspect {

    @Before("execution(* com.mygaienko.controller.*Controller.*(..))")
    public void sleep(JoinPoint joinpoint) throws InterruptedException {
        Thread.sleep(155);
    }

}
