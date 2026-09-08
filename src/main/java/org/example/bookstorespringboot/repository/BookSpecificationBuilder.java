package org.example.bookstorespringboot.repository;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.example.bookstorespringboot.dto.BookSearchParametersDto;
import org.example.bookstorespringboot.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BookSpecificationBuilder implements SpecificationBulider<Book> {

    @Override
    public Specification<Book> build(BookSearchParametersDto params) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (params.titles() != null && params.titles().length > 0) {
                predicates.add(root.get("title").in((Object[]) params.titles()));
            }

            if (params.authors() != null && params.authors().length > 0) {
                predicates.add(root.get("author").in((Object[]) params.authors()));
            }

            if (params.prices() != null && params.prices().length > 0) {
                predicates.add(root.get("price").in((Object[]) params.prices()));
            }

            if (predicates.isEmpty()) {
                return criteriaBuilder.conjunction();
            }

            return params.useOr()
                ? criteriaBuilder.or(predicates.toArray(new Predicate[0]))
                : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
