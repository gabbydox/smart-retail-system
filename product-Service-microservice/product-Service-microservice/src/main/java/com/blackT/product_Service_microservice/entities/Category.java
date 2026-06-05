package com.blackT.product_Service_microservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String categoryName;

    private String categoryDescription;

    @OneToMany(mappedBy = "category", cascade =CascadeType.ALL,orphanRemoval = true )
    private List<Product> products;


    public Category(Long id,String categoryDescription,String categoryName) {
        this.categoryDescription = categoryDescription;
        this.id = id;
        this.categoryName = categoryName;
    }



    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
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
}