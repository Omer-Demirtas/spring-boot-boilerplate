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
    @Pointcut("@within(com.boilerplate.annotation.Log)")
    public void log() {}

    @Before("log()")
    public void adviceBefore(JoinPoint jp)
    {
        log.info(jp.toShortString() + Arrays.toString(jp.getArgs()) + " start...");
    }

    @After("log()")
    public void adviceAfter(JoinPoint jp)
    {
        log.info(jp.toShortString() + Arrays.toString(jp.getArgs()) + " end...");
    }

    @AfterThrowing("log()")
    public void adviceAfterThrowing(JoinPoint jp)
    {
        log.info(jp.toShortString() + Arrays.toString(jp.getArgs()) + " error throw...");
    }
}
