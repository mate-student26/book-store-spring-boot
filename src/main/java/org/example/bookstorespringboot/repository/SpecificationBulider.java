package org.example.bookstorespringboot.repository;

import org.example.bookstorespringboot.dto.BookSearchParametersDto;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBulider<T> {
    Specification<T> build(BookSearchParametersDto params);
}
