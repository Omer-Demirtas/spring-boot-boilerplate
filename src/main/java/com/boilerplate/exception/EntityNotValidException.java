package com.boilerplate.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntityNotValidException extends RuntimeException
{
    public EntityNotValidException(String message)
    {
        super(message);
    }
}
