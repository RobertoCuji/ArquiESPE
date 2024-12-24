package com.biblioteca.book_service.controller;

import com.biblioteca.book_service.dto.BookDto;
import com.biblioteca.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // Agregar un nuevo libro
    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.addBook(bookDto));
    }

    // Verificar disponibilidad de un libro por título
    @GetMapping("/{title}/availability")
    public ResponseEntity<Boolean> isBookAvailable(@PathVariable String title) {
        return ResponseEntity.ok(bookService.isBookAvailable(title));
    }
}
