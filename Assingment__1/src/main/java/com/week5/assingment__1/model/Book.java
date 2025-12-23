package com.week5.assingment__1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title cannot be Empty")
    @Column(nullable = false)
    private String title;
    private  String author;
    @Size(min = 13,max = 13,message = "ISBN must be exactly 13 characters!!")
    @Column(unique = true)
    private String isbn;
    private boolean available =true;
}
