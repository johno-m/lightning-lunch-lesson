package com.sainsburys.lightninglunchbackend.controllers;

import com.sainsburys.lightninglunchbackend.exceptions.ProductNotFoundException;
import com.sainsburys.lightninglunchbackend.services.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("products")

public class ProductsController {

    private ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> getProductDetails(@PathVariable("productId") String productId) throws ProductNotFoundException {
        return ResponseEntity.ok(productsService.getProduct(productId));
    }
}
