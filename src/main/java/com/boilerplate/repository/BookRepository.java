package com.boilerplate.repository;

import com.boilerplate.domain.Book;
import com.boilerplate.dto.BookDTO;
import com.boilerplate.projection.BookView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>
{

    @Query("select new com.boilerplate.dto.BookDTO( " +
            "B.id, B.title) " +
            "from Book B ")
    List<BookDTO> getBooksWithComments();

    @Query(
            "SELECT B.id as id, B.title as title, B.advancedDetails as advancedDetails, BC.title as commentsTitle " +
            "FROM Book B " +
            "LEFT JOIN B.comments BC "
    )
    List<BookView> getExample();

    @Query(
            "SELECT B.id as id, B.title as title, C.id as commentId, C.title as commentTitle " +
            "FROM Book B " +
            "LEFT JOIN B.comments C"
    )
    List<BookView> getBooksWithCommentsView();

    @Query(
            "SELECT DISTINCT new com.boilerplate.dto.BookDTO(B) FROM Book B"
    )
    List<BookDTO> findAllByIdIsNotNull();
}
