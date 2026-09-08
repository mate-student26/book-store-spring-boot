package org.example.bookstorespringboot.repository;

import org.example.bookstorespringboot.dto.BookSearchParametersDto;
import org.example.bookstorespringboot.model.SearchOperator;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(BookSearchParametersDto params, SearchOperator operator);
}
