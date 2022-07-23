package com.boilerplate.controller;

import com.boilerplate.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController
{
    private final PersonService personService;
    @GetMapping("/all")
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(
                "All Person"
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(
            personService.getPersonById(id)
        );
    }
}
