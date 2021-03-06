package com.example.bnta.author_book_lab.controllers;

import com.example.bnta.author_book_lab.models.Author;
import com.example.bnta.author_book_lab.models.Book;
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
//    @GetMapping
//    public ResponseEntity<List<Author>> getAllAuthors() {
//        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping //localhost:8080/authors
    // ?title=Hamlet for if statement
    public ResponseEntity<List<Author>> getAllAuthorsAndFilters(
            @RequestParam(required = false, name = "name") String name
    ){
        if(name != null){
            return new ResponseEntity<>(authorRepository.findByName(name), HttpStatus.OK);
        }
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAuthor (@PathVariable("id") Long id) {
        authorRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
