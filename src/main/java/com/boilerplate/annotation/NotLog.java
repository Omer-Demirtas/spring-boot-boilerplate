package com.boilerplate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * to not log method.
*/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotLog
{ }
