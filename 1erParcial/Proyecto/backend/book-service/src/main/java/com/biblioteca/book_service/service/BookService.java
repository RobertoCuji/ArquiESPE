package com.biblioteca.book_service.service;

import com.biblioteca.book_service.dto.BookDto;
import com.biblioteca.book_service.entity.Book;
import com.biblioteca.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Obtener todos los libros
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookDto::fromEntity)
                .collect(Collectors.toList());
    }

    // Agregar un libro
    public BookDto addBook(BookDto bookDto) {
        // Convertir BookDto a entidad Book
        Book book = BookDto.toEntity(bookDto);

        // Guardar en la base de datos
        Book savedBook = bookRepository.save(book);

        // Convertir Book a BookDto para la respuesta
        return BookDto.fromEntity(savedBook);
    }

    // Verificar disponibilidad de un libro por título
    public boolean isBookAvailable(String title) {
        Book book = bookRepository.findByTitle(title);
        return book != null && book.isAvailable();
    }
}
