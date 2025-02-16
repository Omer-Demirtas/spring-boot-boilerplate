package com.boilerplate.config;

import com.boilerplate.utils.GenericResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public GenericResponse<?> handleEntityNotValid(RuntimeException ex) {
        // TODO fill error code and error message
        return GenericResponse.error();
    }
}
