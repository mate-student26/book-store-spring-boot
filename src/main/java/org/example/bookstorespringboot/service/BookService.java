package org.example.bookstorespringboot.service;

import java.util.List;
import org.example.bookstorespringboot.dto.BookDto;
import org.example.bookstorespringboot.dto.BookSearchParametersDto;
import org.example.bookstorespringboot.dto.CreateBookRequestDto;
import org.example.bookstorespringboot.dto.UpdateBookRequestDto;
import org.example.bookstorespringboot.model.SearchOperator;

public interface BookService {

    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto update(Long id, UpdateBookRequestDto updateBookRequestDto);

    void deleteById(Long id);

    List<BookDto> searchBooks(BookSearchParametersDto params, SearchOperator operator);
}
