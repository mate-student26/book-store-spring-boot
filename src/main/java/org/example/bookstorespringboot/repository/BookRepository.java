package org.example.bookstorespringboot.repository;

import org.example.bookstorespringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
