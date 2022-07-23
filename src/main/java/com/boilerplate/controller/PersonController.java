package com.boilerplate.controller;

import com.boilerplate.dto.ApiResponse;
import com.boilerplate.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController
{
    private final PersonService personService;
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll()
    {
        return ResponseEntity.ok(
                ApiResponse.success(personService.getAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(
            ApiResponse.success(personService.getPersonById(id))
        );
    }
}
