package com.nordstrom.hackathon.matchmaker.service.models;

public class NordResponse {

    private String username;
    private int productId;
    private String value;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return String.format("%s:%d:%s", getUsername(), getProductId(), getValue());
    }
}
