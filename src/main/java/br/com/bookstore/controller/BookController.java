package br.com.bookstore.controller;

import br.com.bookstore.domain.book.Book;
import br.com.bookstore.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/api/v1/books", "/api/v1/books/"})
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        var books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("{title}")
    public ResponseEntity<List<Book>> findAllByTitle(@PathVariable String title) {
        var books = bookService.findAllByTitle(title);
        return ResponseEntity.ok(books);
    }
}
