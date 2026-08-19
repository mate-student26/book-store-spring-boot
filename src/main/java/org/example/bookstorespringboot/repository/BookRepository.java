package org.example.bookstorespringboot.repository;

import java.util.List;
import org.example.bookstorespringboot.model.Book;

public interface BookRepository {

    Book save(Book book);

    List<Book> findAll();
}
