package ru.gb.Seminar004.repository;



import org.springframework.stereotype.Repository;
import ru.gb.Seminar004.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
