package com.biblioteca.book_service;

import com.biblioteca.book_service.entity.Book;
import com.biblioteca.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserta datos iniciales en la base de datos
        bookRepository.save(new Book(null, "Clean Code", "Robert C. Martin", "Programming", true));
        bookRepository.save(new Book(null, "The Pragmatic Programmer", "Andrew Hunt", "Programming", true));
        bookRepository.save(new Book(null, "Refactoring", "Martin Fowler", "Programming", true));

        System.out.println("Datos de libros insertados en la base de datos.");
    }
}
