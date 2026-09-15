package org.example.bookstorespringboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;
import org.example.bookstorespringboot.validation.Isbn;

@Data
public class CreateBookRequestDto {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String author;

    @NotBlank
    @Isbn
    private String isbn;

    @NotNull
    @Min(0)
    private BigDecimal price;

    private String description;

    private String coverImage;
}
