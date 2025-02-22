package com.boilerplate.config;

import com.boilerplate.exception.BaseException;
import com.boilerplate.utils.GenericResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling custom exceptions across the application.
 * <p>
 * This class captures all exceptions that extend {@link BaseException} and provides
 * a unified response format using {@link GenericResponse}. It ensures consistent error
 * handling and logging.
 * </p>
 *
 * @author Omer Demirtas
 */
@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<GenericResponse<?>> handleBaseException(BaseException ex) {
        log.error(ex);

        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ex.toGenericResponse());
    }
}
