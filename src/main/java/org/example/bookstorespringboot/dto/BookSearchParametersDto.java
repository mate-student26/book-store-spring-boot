package org.example.bookstorespringboot.dto;

import java.math.BigDecimal;

public record BookSearchParametersDto(
        String[] titles,
        String[] authors,
        BigDecimal[] prices,
        boolean useOr
) {
}
