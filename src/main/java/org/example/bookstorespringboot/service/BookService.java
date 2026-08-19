package org.example.bookstorespringboot.service;

import java.util.List;
import org.example.bookstorespringboot.model.Book;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();
}
