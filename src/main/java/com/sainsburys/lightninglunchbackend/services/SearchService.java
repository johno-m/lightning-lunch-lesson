package com.sainsburys.lightninglunchbackend.services;

import com.sainsburys.lightninglunchbackend.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private ProductsService productsService;

    public SearchService(ProductsService productsService){
        this.productsService = productsService;
    }

    public List<Product> search(String searchTerm){

        return productsService.getProducts().stream()
                .filter( product ->
                         product.getAttributes().getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                         product.getAttributes().getDescription().toLowerCase().contains(searchTerm.toLowerCase()) )
                .collect(Collectors.toList());

    }

}
