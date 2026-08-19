package org.example.bookstorespringboot.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookstorespringboot.model.Book;
import org.example.bookstorespringboot.repository.BookRepository;
import org.example.bookstorespringboot.service.BookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
