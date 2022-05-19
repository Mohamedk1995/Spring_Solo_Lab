package com.example.bnta.author_book_lab.controllers;

import com.example.bnta.author_book_lab.models.Author;
import com.example.bnta.author_book_lab.models.Book;
import com.example.bnta.author_book_lab.repositories.AuthorRepository;
import com.example.bnta.author_book_lab.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Test;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books") //localhost:8080/books
public class BookController {

    @Autowired
    BookRepository bookRepository;

    //INDEX
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/{id}")//localhost:8080/books/1
    public ResponseEntity<Optional<Book>> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
        bookRepository.save(newBook);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteBook (@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
