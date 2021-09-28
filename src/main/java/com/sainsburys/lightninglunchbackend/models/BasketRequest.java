package com.sainsburys.lightninglunchbackend.models;

/**
 * Contains all the functions related to the Basket
 * */

public class BasketRequest {

    private String productId;
    private int quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
