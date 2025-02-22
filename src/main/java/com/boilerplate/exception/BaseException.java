package com.boilerplate.exception;

import com.boilerplate.utils.GenericResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * Abstract base class for all custom exceptions in the application.
 * <p>
 * This class standardizes the structure of exceptions by including an error code,
 * an error message, and an HTTP status. All custom exceptions should extend this class.
 * </p>
 *
 * @author Omer Demirtas
 */
@Getter
@Setter
@ToString
public abstract class BaseException extends RuntimeException {
    String errorCode;
    String errorMessage;

    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    /**
     * Constructs a new {@code BaseException} with the specified details.
     *
     * @param errorCode    The unique error code.
     * @param errorMessage The error message.
     * @param httpStatus   The associated HTTP status.
     */
    public BaseException(String errorCode, String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);

        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    /**
     * Constructs a new {@code BaseException} with a default HTTP status of {@code INTERNAL_SERVER_ERROR}.
     *
     * @param errorCode    The unique error code.
     * @param errorMessage The error message.
     */
    public BaseException(String errorCode, String errorMessage) {
        super(errorMessage);

        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Converts the exception into a {@link GenericResponse} object.
     *
     * @return A standardized error response.
     */
    public GenericResponse<?> toGenericResponse() {
        return GenericResponse.error()
                .errorCode(getErrorCode())
                .errorMessage(getErrorMessage());
    }
}
