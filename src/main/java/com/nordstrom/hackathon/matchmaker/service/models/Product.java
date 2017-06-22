package com.nordstrom.hackathon.matchmaker.service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(value={"_id"})
public class Product {

    private int productId;
    private String[] colors;
    private int price;
    private String brand;
    private String imageUrl;
    private String[] poses;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @JsonIgnore
    public String[] getColors() {
        return colors;
    }

    @JsonProperty("colors")
    public void setColorString(String colorString) { this.colors = colorString.split(","); }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonIgnore
    public String[] getPoses() {
        return poses;
    }

    @JsonProperty("poses")
    public void setPosesString(String poses) {
        this.poses = poses.split(",");
    }
}
