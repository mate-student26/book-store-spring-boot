package org.example.bookstorespringboot.mapper;

import org.example.bookstorespringboot.config.MapperConfig;
import org.example.bookstorespringboot.dto.BookDto;
import org.example.bookstorespringboot.dto.CreateBookRequestDto;
import org.example.bookstorespringboot.dto.UpdateBookRequestDto;
import org.example.bookstorespringboot.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto createBookRequestDto);

    void updateBookDto(UpdateBookRequestDto updateBookRequestDto, @MappingTarget Book book);
}
