package com.nordstrom.hackathon.matchmaker.service.models;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
