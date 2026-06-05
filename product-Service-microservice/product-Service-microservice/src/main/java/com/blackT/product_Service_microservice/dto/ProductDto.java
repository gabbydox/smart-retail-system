package com.blackT.product_Service_microservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private String barcode;
    private double price;
    private int quantity;
    private LocalDate expiryDate;
    private Long categoryId;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String barcode, double price, int quantity, LocalDate expiryDate, Long categoryId) {
        this.id = id;
        this.name =name;
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public ProductDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public ProductDto setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductDto setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public ProductDto setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
