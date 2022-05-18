package com.example.bnta.author_book_lab.controllers;

import com.example.bnta.author_book_lab.models.Author;
import com.example.bnta.author_book_lab.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("authors") //localhost:8080/authors
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    //INDEX
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value="/{id}")//localhost:8080/authors/1
    public ResponseEntity <Optional<Author>> getAuthor(@PathVariable Long id) {
        return new ResponseEntity<>(authorRepository.findById(id),HttpStatus.OK);
    }

    //POST
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author newAuthor) {
        authorRepository.save(newAuthor);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

}
