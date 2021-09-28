package com.sainsburys.lightninglunchbackend.services;

import com.sainsburys.lightninglunchbackend.exceptions.ProductNotFoundException;
import com.sainsburys.lightninglunchbackend.models.Basket;
import com.sainsburys.lightninglunchbackend.models.BasketRequest;
import com.sainsburys.lightninglunchbackend.models.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BasketsService {

    private ProductsService productsService;

    private Map<String, Basket> baskets = new HashMap<>();

    public BasketsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    /** Creates the basket | (BasketRequest basketRequest) */
    public Basket createBasket(BasketRequest basketRequest) throws ProductNotFoundException {
        Basket basket = new Basket();
        baskets.put(basket.getId(), basket);

        Product product = productsService.getProduct(basketRequest.getProductId());

        basket.addToBasket(product, basketRequest.getQuantity());
        return basket;
    }

    /** Returns the basket with that ID (String basketId) */
    public Basket getBasket(String basketId){
        return baskets.get(basketId);
    }

    /** Adds to the basket (String basketId, BasketRequest basketRequest) */
    public Basket addToBasket(String basketId, BasketRequest basketRequest) throws ProductNotFoundException {
        Basket basket = baskets.get(basketId);

        Product product = productsService.getProduct(basketRequest.getProductId());

        basket.addToBasket(product, basketRequest.getQuantity());
        return basket;
    }

}
