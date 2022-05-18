package com.example.bnta.author_book_lab.repositories;

import com.example.bnta.author_book_lab.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
