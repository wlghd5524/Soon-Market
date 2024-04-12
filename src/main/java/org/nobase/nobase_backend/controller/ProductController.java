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
            @RequestParam("pd_image") MultipartFile imageFile
    ) {
        try {
            String mb_id = productDTO.getMb_id();
            String pd_title = productDTO.getPd_title();
            String pd_des = productDTO.getPd_des();
            double pd_price = productDTO.getPd_price();
            String category = productDTO.getCategory();
            String sh_size = productDTO.getSh_size();
            String mb_nickname = productDTO.getMb_nickname();

            Product product = productService.createProduct(mb_id, mb_nickname, pd_title, pd_des, pd_price, category, imageFile, sh_size);
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