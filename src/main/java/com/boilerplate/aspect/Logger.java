package com.boilerplate.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Log4j2
@Aspect
@Component
public class Logger
{
    /*
    @Pointcut("@within(com.boilerplate.annotation.LogClass)")
    public void logClass() {}

    @Pointcut("@annotation(com.boilerplate.annotation.LogMethod)")
    public void logMethod() {}
    */

    @Pointcut("@annotation(com.boilerplate.annotation.NotLog)")
    public void notLogMethod() {}

    @Pointcut("@within(com.boilerplate.annotation.LogThrowClass)")
    public void logThrowClass() {}

    @Pointcut("@annotation(com.boilerplate.annotation.LogThrowMethod)")
    public void logThrowMethod() {}

    //@Before("(logClass() || logMethod()) && !notLogMethod()")
    @Before("execution(* com.boilerplate.service.*.*(..)) && !notLogMethod()")
    public void adviceBefore(JoinPoint jp)
    {
        log.info(jp.toShortString() + Arrays.toString(jp.getArgs()) + " start...");
    }

    @After("execution(* com.boilerplate.service.*.*(..)) && !notLogMethod()")
    public void adviceAfter(JoinPoint jp)
    {
        log.info(jp.toShortString() + Arrays.toString(jp.getArgs()) + " end...");
    }

    @AfterThrowing(value = "logThrowClass() || logThrowMethod()", throwing = "ex")
    public void adviceAfterThrowing(JoinPoint jp, Exception ex)
    {
        log.info("{}{} | {} {}", jp.toShortString(), Arrays.toString(jp.getArgs()), ex.getClass().getName(), ex.getMessage());
    }
}
