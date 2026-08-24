package org.example.bookstorespringboot.repository.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.bookstorespringboot.dto.CreateBookRequestDto;
import org.example.bookstorespringboot.model.Book;
import org.example.bookstorespringboot.repository.BookRepository;
import org.example.bookstorespringboot.repository.JpaBookRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final JpaBookRepository jpaBookRepository;
    private final CreateBookRequestDto createBookRequestDto;

    @Override
    public Book save(Book book) {
        return jpaBookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return jpaBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        Book byId = jpaBookRepository.findById(id);
        return byId != null ? Optional.of(byId) : Optional.empty();
    }
}
