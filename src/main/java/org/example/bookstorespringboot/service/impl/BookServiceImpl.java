package org.example.bookstorespringboot.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookstorespringboot.dto.BookDto;
import org.example.bookstorespringboot.dto.CreateBookRequestDto;
import org.example.bookstorespringboot.exception.EntityNotFoundException;
import org.example.bookstorespringboot.mapper.BookMapper;
import org.example.bookstorespringboot.model.Book;
import org.example.bookstorespringboot.repository.BookRepository;
import org.example.bookstorespringboot.service.BookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toModel(createBookRequestDto);
        Book saved = bookRepository.save(book);
        return bookMapper.toDto(saved);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
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
}
