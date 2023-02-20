package com.boilerplate.controller;

import com.boilerplate.domain.User;
import com.boilerplate.dto.ApiResponse;
import com.boilerplate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class UserController
{
    private final UserService userService;

    @GetMapping("/all")
    public ApiResponse getAll()
    {
        return ApiResponse.success(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable("id") Long id) throws Exception
    {
        return ResponseEntity.ok(
            ApiResponse.success(userService.getPersonById(id))
        );
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> create(@RequestBody User user)
    {
        return ResponseEntity.ok(
                ApiResponse.success(userService.create(user))
        );
    }
}
