package com.nordstrom.hackathon.matchmaker.service.services;

import com.nordstrom.hackathon.matchmaker.service.clients.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class ProductService {

    private ProductClient productClient;

    @Autowired
    public ProductService(ProductClient productClient) {

        this.productClient = productClient;
    }

    public String getProductsJson() throws UnsupportedEncodingException {

        return productClient.getProductsJson();
    }
}
