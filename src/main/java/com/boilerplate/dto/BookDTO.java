package com.boilerplate.dto;

import com.boilerplate.domain.Book;
import com.boilerplate.domain.BookComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO
{
    Long id;
    String title;

    Set<BookCommentDTO> comments;

    public BookDTO(Long id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public BookDTO(Book book)
    {
        this.id = book.getId();
        this.title = book.getTitle();
        this.comments = book.getComments().stream().map(bookComment -> new BookCommentDTO(bookComment.getId(), bookComment.getTitle())).collect(Collectors.toSet());
    }
}
