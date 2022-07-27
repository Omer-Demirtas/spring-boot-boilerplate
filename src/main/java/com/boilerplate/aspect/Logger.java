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
    @Pointcut("@within(com.boilerplate.annotation.LogClass)")
    public void logClass() {}

    @Pointcut("@annotation(com.boilerplate.annotation.LogMethod)")
    public void logMethod() {}

    @Pointcut("@annotation(com.boilerplate.annotation.NotLogMethod)")
    public void notLogMethod() {}

    @Before("(logClass() || logMethod()) && !notLogMethod()")
    public void adviceBefore(JoinPoint jp)
    {
        log.info(jp.toShortString() + Arrays.toString(jp.getArgs()) + " start...");
    }

    @After("(logClass() || logMethod()) && !notLogMethod()")
    public void adviceAfter(JoinPoint jp)
    {
        log.info(jp.toShortString() + Arrays.toString(jp.getArgs()) + " end...");
    }

    @AfterThrowing("(logClass() || logMethod()) && !notLogMethod()")
    public void adviceAfterThrowing(JoinPoint jp)
    {
        log.info(jp.toShortString() + Arrays.toString(jp.getArgs()) + " error throw...");
    }
}
