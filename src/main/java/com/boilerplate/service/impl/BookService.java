package com.boilerplate.service.impl;

import com.boilerplate.domain.Book;
import com.boilerplate.dto.BookDTO;
import com.boilerplate.repository.BookRepository;
import com.boilerplate.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService
{
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;

    public List<Book> getAll()
    {
        return bookRepository.findAll();
    }

    public List<?> getTest()
    {
        return bookRepository.findAllByIdIsNotNull();
        /*
        List<BookDTO> books = bookRepository.getBooksWithComments();

        books.forEach(bookDTO -> bookDTO.setComments(commentRepository.getAllByBookId(bookDTO.getId())));

        return books;*/
    }
}
