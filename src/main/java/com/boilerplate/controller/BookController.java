package com.boilerplate.controller;

import com.boilerplate.domain.Book;
import com.boilerplate.service.impl.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController
{
    private final BookService bookService;

    @GetMapping()
    public List<Book> getAll()
    {
        return bookService.getAll();
    }

    @GetMapping("/test")
    public List<?> getTest()
    {
        return bookService.getTest();
    }
}
