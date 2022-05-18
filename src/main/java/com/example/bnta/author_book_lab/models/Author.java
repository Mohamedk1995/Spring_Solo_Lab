package com.example.bnta.author_book_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private String genre;

    @OneToMany(mappedBy = "author") //mapped by = name of the property in 'Book' that's to be FK
    @JsonIgnoreProperties({"author"})
    private List<Book> books;

    public Author(String name, String title, String genre) {
        this.name = name;
        this.title = title;
        this.genre = genre;
        this.books = new ArrayList<Book>();
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
