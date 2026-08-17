package org.example.bookstorespringboot;

import org.example.bookstorespringboot.model.Book;
import org.example.bookstorespringboot.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BookStoreSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner (BookService bookService) {
        return args ->  {
            Book book1 = new Book();
            book1.setTitle("Book 1");
            book1.setAuthor("Author 1");
            book1.setIsbn("ISBN 1");
            book1.setPrice(BigDecimal.TEN);

            bookService.save(book1);

            bookService.findAll().forEach(System.out::println);
        };
    }
}
