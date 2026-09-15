package org.example.bookstorespringboot.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        String errorCode,
        String message,
        Map<String, String> validationErrors,
        LocalDateTime timestamp
) {
}
