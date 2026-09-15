package org.example.bookstorespringboot.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookstorespringboot.dto.BookDto;
import org.example.bookstorespringboot.dto.BookSearchParametersDto;
import org.example.bookstorespringboot.dto.CreateBookRequestDto;
import org.example.bookstorespringboot.dto.UpdateBookRequestDto;
import org.example.bookstorespringboot.exception.EntityNotFoundException;
import org.example.bookstorespringboot.exception.NoParamsChosenException;
import org.example.bookstorespringboot.mapper.BookMapper;
import org.example.bookstorespringboot.model.Book;
import org.example.bookstorespringboot.model.SearchOperator;
import org.example.bookstorespringboot.repository.BookRepository;
import org.example.bookstorespringboot.repository.BookSpecificationBuilder;
import org.example.bookstorespringboot.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toModel(createBookRequestDto);
        book.setIsbn(normalizeIsbn(book.getIsbn()));
        Book saved = bookRepository.save(book);
        return bookMapper.toDto(saved);
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find book by id " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto update(Long id, UpdateBookRequestDto updateBookRequestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find book by id " + id));

        bookMapper.updateBookDto(updateBookRequestDto, book);
        book.setIsbn(normalizeIsbn(book.getIsbn()));
        Book updatedBook = bookRepository.save(book);

        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find book by id " + id));

        bookRepository.delete(book);
    }

    @Override
    public List<BookDto> searchBooks(BookSearchParametersDto params, SearchOperator operator) {

        if (params.titles() == null
                && params.authors() == null
                && params.minPrice() == null
                && params.maxPrice() == null) {
            throw new NoParamsChosenException(
                    "You must provide at least one search parameter");
        }

        Specification<Book> bookSpecification = bookSpecificationBuilder.build(params, operator);

        return bookRepository.findAll(bookSpecification)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    private String normalizeIsbn(String isbn) {
        return isbn.replaceAll("[\\s-]", "");
    }
}
