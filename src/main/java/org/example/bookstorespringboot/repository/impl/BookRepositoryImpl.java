package org.example.bookstorespringboot.repository.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookstorespringboot.model.Book;
import org.example.bookstorespringboot.repository.BookRepository;
import org.example.bookstorespringboot.repository.JpaBookRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final JpaBookRepository jpaBookRepository;

    @Override
    public Book save(Book book) {
        return jpaBookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return jpaBookRepository.findAll();
    }
}
