package com.boilerplate.config;

import com.boilerplate.exception.BaseException;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * Exception representing a "not found" scenario.
 *
 * @author Omer Demirtas
 */
@ToString(callSuper = true)
public class NotFoundException extends BaseException {
    public NotFoundException(String errorMessage) {
        // TODO: make errorCode from central code base
        super("notFound", errorMessage, HttpStatus.NOT_FOUND);
    }
}
