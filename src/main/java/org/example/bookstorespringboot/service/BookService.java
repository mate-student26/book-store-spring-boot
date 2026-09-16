package org.example.bookstorespringboot.service;

import org.example.bookstorespringboot.dto.BookDto;
import org.example.bookstorespringboot.dto.BookSearchParametersDto;
import org.example.bookstorespringboot.dto.CreateBookRequestDto;
import org.example.bookstorespringboot.dto.UpdateBookRequestDto;
import org.example.bookstorespringboot.model.SearchOperator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookDto save(CreateBookRequestDto createBookRequestDto);

    Page<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    BookDto update(Long id, UpdateBookRequestDto updateBookRequestDto);

    void deleteById(Long id);

    Page<BookDto> searchBooks(BookSearchParametersDto params,
                              SearchOperator operator,
                              Pageable pageable);
}
