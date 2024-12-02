package com.biblioteca.book_service.dto;

import com.biblioteca.book_service.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String category;
    private boolean available;


    public static BookDto fromEntity(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.isAvailable());
    }
    
    public static Book toEntity(BookDto bookDto) {
        return Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .category(bookDto.getCategory())
                .available(bookDto.isAvailable())
                .build();
    }
    
}