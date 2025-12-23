package com.week5.assingment__1.service;

import com.week5.assingment__1.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private BookService bookService;
    @Autowired
    private  MemberService memberService;
    public Book borrowBook(Long memberid,Long bookid){
        memberService.getMemberById(memberid).orElseThrow(()->new RuntimeException("Invalid Member Id"));
        Book book= bookService.getBookById(bookid).orElseThrow(() ->new RuntimeException("Book doesnt exits by this ID: "+bookid)) ;
        if(!book.isAvailable()){
            throw new RuntimeException("Book is borrowed");
        }
        return bookService.borrowBook(bookid);
    }
    public Book returnBook(Long memberid,Long bookid){
        memberService.getMemberById(memberid).orElseThrow(()->new RuntimeException("Invalid Member Id"));
        Book book= bookService.getBookById(bookid).orElseThrow(() ->new RuntimeException("Book doesnt exits by this ID: "+bookid)) ;
       return bookService.returnBook(bookid);
    }
}
