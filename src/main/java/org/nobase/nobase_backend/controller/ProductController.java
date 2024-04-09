package org.nobase.nobase_backend.controller;

import org.nobase.nobase_backend.entity.Product;
import org.nobase.nobase_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @ModelAttribute ProductDTO productDTO,
            @RequestParam("image") MultipartFile imageFile
    ) {
        try {
            String userId = productDTO.getUserId();
            String title = productDTO.getTitle();
            String content = productDTO.getContent();
            double price = productDTO.getPrice();
            String category = productDTO.getCategory();
            String size = productDTO.getSize();
            String username = productDTO.getUsername();

            Product product = productService.createProduct(userId, username, title, content, price, category, imageFile, size);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}