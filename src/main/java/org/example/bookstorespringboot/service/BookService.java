package org.example.bookstorespringboot.service;

import java.util.List;
import org.example.bookstorespringboot.dto.BookDto;
import org.example.bookstorespringboot.dto.CreateBookRequestDto;

public interface BookService {

    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto update(Long id, BookDto bookDto);

    void deleteById(Long id);
}
