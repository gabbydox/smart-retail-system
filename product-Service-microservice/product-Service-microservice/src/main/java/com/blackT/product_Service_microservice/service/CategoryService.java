package com.blackT.product_Service_microservice.service;

import com.blackT.product_Service_microservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto getByCategory(Long id);

    List<CategoryDto> getAllCategory();

    CategoryDto updateCategory(CategoryDto categoryDto,Long id);

    void deleteCategory(Long id);

}
