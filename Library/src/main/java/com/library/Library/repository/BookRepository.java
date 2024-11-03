package com.library.Library.repository;

import com.library.Library.model.BookLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookLibrary, Long> {
}
