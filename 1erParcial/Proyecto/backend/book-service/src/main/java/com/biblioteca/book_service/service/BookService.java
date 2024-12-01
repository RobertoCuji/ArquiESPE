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

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.isAvailable()))
                .collect(Collectors.toList());
    }

    public BookDto addBook(BookDto bookDto) {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .category(bookDto.getCategory())
                .available(bookDto.isAvailable())
                .build();
        Book savedBook = bookRepository.save(book);
        return new BookDto(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getCategory(), savedBook.isAvailable());
    }

    public boolean isBookAvailable(String title) {
        Book book = bookRepository.findByTitle(title);
        return book != null && book.isAvailable();
    }
}
