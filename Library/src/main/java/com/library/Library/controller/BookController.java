package com.library.Library.controller;

import com.library.Library.rabbitmq.BookMessageSender;
import com.library.Library.model.BookLibrary;
import com.library.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMessageSender bookMessageSender;

    @GetMapping
    public List<BookLibrary> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookLibrary> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookLibrary> createBook(@RequestBody BookLibrary book) {
//        BookLibrary savedBook = bookRepository.save(book);
        bookMessageSender.sendBookMessage(book, "CREATE");
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookLibrary> updateBook(@PathVariable Long id, @RequestBody BookLibrary updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    updatedBook.setId(id);
//                    BookLibrary savedBook = bookRepository.save(updatedBook);
                    bookMessageSender.sendBookMessage(updatedBook, "UPDATE");
                    return ResponseEntity.ok(updatedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
//            bookRepository.deleteById(id);
            bookMessageSender.sendBookMessage(new BookLibrary(id, null, null, null), "DELETE");
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}