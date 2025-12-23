package com.week5.assingment__1.controller;

import com.week5.assingment__1.model.Book;
import com.week5.assingment__1.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/api/books")
    public Book createBook(@Valid @RequestBody Book book){
        return bookService.addBook(book);
    }
    @GetMapping("/api/books")
    public List<Book>getAllBooks(){
        return bookService.getAllBook();
    }
    @GetMapping("/api/books/available")
    public List<Book> getAvailableBook(){
        return bookService.getAvailableBooks();
    }
    @GetMapping("api/books/{id}")
    public Optional<Book>getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

}
