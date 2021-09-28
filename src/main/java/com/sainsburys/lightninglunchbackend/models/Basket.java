package com.sainsburys.lightninglunchbackend.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Basket {

    private final String id = UUID.randomUUID().toString();
    private List<BasketItem> basketItems = new ArrayList<>();

    public String getId() {
        return id;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void addToBasket(Product product, int quantity){
        BasketItem basketItem = new BasketItem();
        basketItem.setProduct(product);
        basketItem.setQuantity(quantity);
        basketItems.add(basketItem);
    }
}
