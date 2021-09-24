package com.sainsburys.lightninglunchbackend.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sainsburys.lightninglunchbackend.exceptions.ProductNotFoundException;
import com.sainsburys.lightninglunchbackend.models.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void loadData(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            products = mapper.readValue(
                    getClass().getResourceAsStream("/products.json"),
                    new TypeReference<>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(String productId) throws ProductNotFoundException {

        return products.stream()
                .filter( product -> product.getId().equals(productId) )
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException());

//        for (Product product : products) {
//            if (product.getId().equals(productId)) {
//                return product;
//            }
//        }
//        for(int i = 0; i < products.size(); i++){
//            if(products.get(i).getId().equals(productId)){
//                return products.get(i);
//            }
//        }
//        throw new ProductNotFoundException();
    }

    public List<Product> getProducts() {
        return products;
    }
}
