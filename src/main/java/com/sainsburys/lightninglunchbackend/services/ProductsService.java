package com.sainsburys.lightninglunchbackend.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public List<Product> getProducts() {
        return products;
    }
}
