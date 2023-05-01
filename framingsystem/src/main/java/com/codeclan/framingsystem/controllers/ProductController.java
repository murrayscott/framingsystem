package com.codeclan.framingsystem.controllers;

import com.codeclan.framingsystem.models.Order;
import com.codeclan.framingsystem.models.Product;
import com.codeclan.framingsystem.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(name = "id", required = false) Long id
    ){
        if (id != null){
            return new ResponseEntity<>(productRepository.findProductById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }
}
