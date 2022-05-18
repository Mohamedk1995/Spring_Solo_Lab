package com.example.bnta.author_book_lab.components;

import com.example.bnta.author_book_lab.models.Author;
import com.example.bnta.author_book_lab.models.Book;
import com.example.bnta.author_book_lab.repositories.AuthorRepository;
import com.example.bnta.author_book_lab.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //collected Authors together and books so that data can be added easily and keeps code clean.
        Author author1 = new Author("William Shakespeare");
        Author author2 = new Author("George Orwell");
        authorRepository.saveAll(Arrays.asList(author1,author2));

        Book book1 = new Book("Hamlet", "Drama", author1);
        Book book2 = new Book("Macbeth", "Drama", author1);
        Book book3 = new Book("Othello", "Drama", author1);
        Book book4 = new Book("1984", "Dystopian", author2);
        Book book5 = new Book("Animal Farm", "Political Satire", author2);
        bookRepository.saveAll(Arrays.asList(book1,book2,book3,book4,book5));


    }
}
