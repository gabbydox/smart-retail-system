package com.blackT.product_Service_microservice.repository;

import com.blackT.product_Service_microservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
