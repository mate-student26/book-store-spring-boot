package org.example.bookstorespringboot.dto;

import jakarta.validation.constraints.Min;
import java.math.BigDecimal;
import org.example.bookstorespringboot.validation.Isbn;

public record UpdateBookRequestDto(
        String title,
        String author,

        @Isbn
        String isbn,

        @Min(0)
        BigDecimal price,
        String description,
        String coverImage
) {
}
