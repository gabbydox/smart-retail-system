package com.blackT.product_Service_microservice.service.impl;

import com.blackT.product_Service_microservice.entities.Category;
import com.blackT.product_Service_microservice.dto.CategoryDto;
import com.blackT.product_Service_microservice.repository.CategoryRepository;
import com.blackT.product_Service_microservice.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl  implements CategoryService {


    private final  CategoryRepository categoryRepository;
    private  final  ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {

        // convert CategoryDto to Category Jpa entity

        Category category = modelMapper.map(categoryDto,Category.class);

                 Category savedCategory = categoryRepository.save(category);

                 CategoryDto savedCategoryDto = modelMapper.map(savedCategory,CategoryDto.class);

                         return savedCategoryDto;
    }

    @Override
    public CategoryDto getByCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->  new RuntimeException("Category not found with id "+ id)
        );

        return modelMapper.map(category ,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {

        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream().map((category )-> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {

        Category category =  categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("category not found with id:" + id));

        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCategory = categoryRepository.save(category);

        return modelMapper.map(updatedCategory,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("category not found with id:"+ id));

        categoryRepository.deleteById(id);
    }


}
