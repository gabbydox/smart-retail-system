package com.blackT.product_Service_microservice.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {

    private Long id;


    private String categoryName;

    private String categoryDescription;

    private List<CategoryDto> products;

    public CategoryDto(Long id,String categoryName,String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public CategoryDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<CategoryDto> getProducts() {
        return products;
    }

    public CategoryDto setProducts(List<CategoryDto> products) {
        this.products = products;
        return this;
    }
}
