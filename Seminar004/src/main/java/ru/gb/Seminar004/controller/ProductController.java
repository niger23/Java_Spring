package ru.gb.Seminar004.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.Seminar004.model.Product;
import ru.gb.Seminar004.repository.ProductRepository;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductRepository productRepository;

    @GetMapping("/products")
    public String getProduct(Model model) {
        model.addAttribute("products", productRepository.getProducts());
        return "products";
    }
    @PostMapping("/products")
    public String addProduct(Model model, Product product) {
        productRepository.addProduct(product);
        model.addAttribute("products", productRepository.getProducts());
        return "products";
    }

}
