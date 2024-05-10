package ru.gb.Seminar0052.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Seminar0052.model.Book;
import ru.gb.Seminar0052.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    public void deleteBookById(Book book) {
        bookRepository.deleteById(book.getId());
    }
    public Book updateBook(Long id, Book bookDetails){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublicationYear(bookDetails.getPublicationYear());
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }
}
