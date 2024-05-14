package ru.gb.Seminar0061.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Seminar0061.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
