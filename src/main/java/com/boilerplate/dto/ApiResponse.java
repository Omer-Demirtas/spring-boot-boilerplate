package com.boilerplate.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse
{
    private Object data;
    private String code;
    private String message;
    private HttpStatus status;
    private LocalDateTime time;

    public static ApiResponse success(Object data)
    {
        return ApiResponse.builder().data(data).status(HttpStatus.CREATED).build();
    }

    public ApiResponse(HttpStatus status, String message)
    {
        this.status = status;
        this.message = message;
    }
}
