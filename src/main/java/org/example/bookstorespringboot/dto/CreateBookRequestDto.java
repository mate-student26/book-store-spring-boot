package org.example.bookstorespringboot.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CreateBookRequestDto {
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private String description;
    private String coverImage;
}
