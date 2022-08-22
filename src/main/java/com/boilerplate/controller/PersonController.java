package com.boilerplate.controller;

import com.boilerplate.domain.Person;
import com.boilerplate.dto.ApiResponse;
import com.boilerplate.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController
{
    private final PersonService personService;

    @GetMapping("/hello")
    public ApiResponse helloWorld()
    {
        return ApiResponse.success("Hello, World");
    }

    @GetMapping("/dashboard")
    public ApiResponse dashboard()
    {
        return ApiResponse.success("Dashboard");
    }

    @GetMapping("/all")
    public ApiResponse getAll()
    {
        return ApiResponse.success(personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable("id") Long id) throws Exception
    {
        return ResponseEntity.ok(
            ApiResponse.success(personService.getPersonById(id))
        );
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> create(@RequestBody Person person)
    {
        return ResponseEntity.ok(
                ApiResponse.success(personService.create(person))
        );
    }
}
