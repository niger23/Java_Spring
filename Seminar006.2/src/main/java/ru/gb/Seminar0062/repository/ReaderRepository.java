package ru.gb.Seminar0062.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Seminar0062.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
