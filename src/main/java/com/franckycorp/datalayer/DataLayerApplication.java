package com.franckycorp.datalayer;

import com.franckycorp.datalayer.model.Category;
import com.franckycorp.datalayer.model.Comment;
import com.franckycorp.datalayer.model.Product;

import com.franckycorp.datalayer.repository.CategoryRepository;
import com.franckycorp.datalayer.repository.CommentRepository;
import com.franckycorp.datalayer.service.CategoryService;
import com.franckycorp.datalayer.service.CommentService;
import com.franckycorp.datalayer.service.ProductService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

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

        showCategories();

        Category newCategory = new Category();
        newCategory.setName("Promotion");

        newCategory = categoryService.addCategory(newCategory);

        showCategories();

        Product newProduct = new Product();
        newProduct.setName("AssuranceTest");
        newProduct.setDescription("Nouvelle assurance en cours de test");
        newProduct.setCost(1180);

        newCategory.addProduct(newProduct);

        newProduct = productService.addProduct(newProduct);

        showProducts();

        newProduct.getCategories().forEach(
                category -> System.out.println(category.getName())
        );

        Comment newComment = new Comment();
        newComment.setContent("Assurance extra !");
        newProduct.addComment(newComment);

        commentService.addComment(newComment);
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
