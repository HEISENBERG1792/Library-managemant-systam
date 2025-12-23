package com.week5.assingment__1.controller;

import com.week5.assingment__1.service.LibraryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/api/library/borrow")
    public ResponseEntity<String> borrowBook(@RequestBody LibraryRequest request) {
        try {
            libraryService.borrowBook(request.getMemberId(), request.getBookId());
            return ResponseEntity.ok("Book borrowed successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/api/library/return")
    public ResponseEntity<String> returnBook(@RequestBody LibraryRequest request) {
        try {
            libraryService.returnBook(request.getMemberId(), request.getBookId());
            return ResponseEntity.ok("Book returned successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @Getter
    @Setter
    public static class LibraryRequest {
        private Long memberId;
        private Long bookId;

    }
}
