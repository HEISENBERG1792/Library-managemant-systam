package com.week5.assingment__1.repository;

import com.week5.assingment__1.model.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,  Long> {
    Optional<Book> findByIsbn(String isbn);
    List<Book>findByAvailable(boolean available);
}
