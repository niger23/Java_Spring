package ru.gb.Seminar0061.service;

import ru.gb.Seminar0061.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Product product);
    Product createProduct(Product product);
    void deleteProduct(Long id);
}
