package com.sainsburys.lightninglunchbackend.models;

public class Product {

    private String id;
    private String type;
    private ProductAttributes attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(ProductAttributes attributes) {
        this.attributes = attributes;
    }
}
