package com.week5.assingment__1.service;

import com.week5.assingment__1.model.Book;
import com.week5.assingment__1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private  BookRepository bookRepository;

    public Book addBook(Book b){
        return bookRepository.save(b);
    }
    public List<Book>getAllBook(){
        return bookRepository.findAll();
    }
    public List<Book> getAvailableBooks(){
        return bookRepository.findByAvailable(true);
    }
    public Book borrowBook(Long bookId) {
        Book book =bookRepository.findById(bookId).orElseThrow(() ->new RuntimeException("Cannot Borrow:Invalid Id!!"));;

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is already borrowed!");
        }
        book.setAvailable(false);
        return bookRepository.save(book);
    }
    public Book returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->new RuntimeException("Cannot return:Invalid Book Id!!"));

        book.setAvailable(true);
        return bookRepository.save(book);
    }
    public Optional<Book> getBookById(long id){
        return bookRepository.findById(id);
    }
}
