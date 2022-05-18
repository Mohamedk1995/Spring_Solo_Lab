package com.example.bnta.author_book_lab.repositories;

import com.example.bnta.author_book_lab.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
