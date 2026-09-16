package org.example.bookstorespringboot.repository;

import org.example.bookstorespringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>,
        JpaSpecificationExecutor<Book> {
    boolean existsByIsbn(String normalizedIsbn);
}
