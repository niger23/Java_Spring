package ru.gb.Seminar0052.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.Seminar0052.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
