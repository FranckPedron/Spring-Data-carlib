package com.franckycorp.datalayer;

import com.franckycorp.datalayer.model.Product;

import com.franckycorp.datalayer.repository.CommentRepository;
import com.franckycorp.datalayer.service.CategoryService;
import com.franckycorp.datalayer.service.CommentService;
import com.franckycorp.datalayer.service.ProductService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentRepository commentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DataLayerApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Iterable<Product> searchResults = productService.getProductsByName("AssuranceTousRisques");
        searchResults.forEach(product -> System.out.println(product.getProductId()));

        searchResults = productService.getProductsByCategoryName("standard");
        searchResults.forEach(product -> System.out.println(product.getName()));
    }

    public void showCategories() {
        categoryService.getCategories().forEach(
                category -> System.out.println(category.getName())
        );
    }

    public void showProducts() {
        productService.getProducts().forEach(
                product -> System.out.println(product.getName())
        );
    }
}
