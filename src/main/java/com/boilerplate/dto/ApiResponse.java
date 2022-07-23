package com.boilerplate.dto;

import com.boilerplate.domain.Person;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse
{
    private String code;
    private String message;
    private Object data;
    private LocalDateTime time;


    public static ApiResponse success(Object data)
    {
        return ApiResponse.builder().data(data).build();
    }
}
