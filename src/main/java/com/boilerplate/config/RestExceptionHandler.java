package com.boilerplate.config;

import com.boilerplate.dto.ApiResponse;
import com.boilerplate.exception.EntityNotValidException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String error = "Malformed JSON request";
        return new ResponseEntity<>(
            new ApiResponse(HttpStatus.BAD_REQUEST, error),
            BAD_REQUEST
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<ApiResponse> handleEntityNotFound(EntityNotFoundException ex)
    {
        ApiResponse apiResponse = new ApiResponse(NOT_FOUND, ex.getMessage());
        return buildResponseEntity(apiResponse);
    }

    @ExceptionHandler(EntityNotValidException.class)
    protected ResponseEntity<ApiResponse> handleEntityNotValid(EntityNotValidException ex)
    {
        ApiResponse apiResponse = new ApiResponse(BAD_REQUEST, ex.getMessage());
        return buildResponseEntity(apiResponse);
    }

    private ResponseEntity<ApiResponse> buildResponseEntity(ApiResponse apiResponse)
    {
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }
}
