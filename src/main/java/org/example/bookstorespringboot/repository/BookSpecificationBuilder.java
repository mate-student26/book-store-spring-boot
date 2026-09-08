package org.example.bookstorespringboot.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.bookstorespringboot.dto.BookSearchParametersDto;
import org.example.bookstorespringboot.model.Book;
import org.example.bookstorespringboot.model.SearchOperator;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {

    @Override
    public Specification<Book> build(BookSearchParametersDto params, SearchOperator operator) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            addTitlePredicate(predicates, root, params);
            addAuthorPredicate(predicates, root, params);
            addPricePredicate(predicates, root, criteriaBuilder, params);

            if (predicates.isEmpty()) {
                return criteriaBuilder.conjunction();
            }

            if (operator == SearchOperator.AND) {
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }

    private void addTitlePredicate(List<Predicate> predicates,
                                   Root<Book> root,
                                   BookSearchParametersDto params) {

        if (params.titles() != null) {
            String[] filteredTitles = Arrays.stream(params.titles())
                    .filter(s -> s != null && !s.isBlank())
                    .toArray(String[]::new);

            if (filteredTitles.length > 0) {
                predicates.add(root.get("title").in(filteredTitles));
            }
        }

    }

    private void addAuthorPredicate(List<Predicate> predicates,
                                    Root<Book> root,
                                    BookSearchParametersDto params) {

        if (params.authors() != null) {
            String[] filteredAuthors = Arrays.stream(params.authors())
                    .filter(s -> s != null && !s.isBlank())
                    .toArray(String[]::new);

            if (filteredAuthors.length > 0) {
                predicates.add(root.get("author").in(filteredAuthors));
            }
        }
    }

    private void addPricePredicate(List<Predicate> predicates,
                                   Root<Book> root,
                                   CriteriaBuilder cb,
                                   BookSearchParametersDto params) {

        if (params.minPrice() != null) {
            predicates.add(cb
                    .greaterThanOrEqualTo(root.<BigDecimal>get("price"), params.minPrice()));
        }

        if (params.maxPrice() != null) {
            predicates.add(cb
                    .lessThanOrEqualTo(root.<BigDecimal>get("price"), params.maxPrice()));
        }
    }
}

