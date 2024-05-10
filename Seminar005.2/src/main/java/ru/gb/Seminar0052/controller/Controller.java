package ru.gb.Seminar0052.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.Seminar0052.model.Book;
import ru.gb.Seminar0052.service.BookService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class Controller {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


}
