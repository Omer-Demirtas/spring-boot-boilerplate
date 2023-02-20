package com.boilerplate.repository;

import com.boilerplate.domain.BookComment;
import com.boilerplate.dto.BookCommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CommentRepository extends JpaRepository<BookComment, Long>
{
    @Query(
            "SELECT new com.boilerplate.dto.BookCommentDTO(BC.id, BC.title) FROM BookComment BC WHERE BC.book.id = :bookId"
    )
    Set<BookCommentDTO> getAllByBookId(@Param("bookId") Long bookId);
}
