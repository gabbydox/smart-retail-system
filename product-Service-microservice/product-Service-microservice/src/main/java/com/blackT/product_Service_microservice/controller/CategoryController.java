package com.blackT.product_Service_microservice.controller;


import com.blackT.product_Service_microservice.dto.CategoryDto;
import com.blackT.product_Service_microservice.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/category")
@RestController
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

      @PostMapping
     public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){

        CategoryDto savedCategory = categoryService.saveCategory(categoryDto);
         return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
      }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getByCategory(@PathVariable Long id ){

        CategoryDto categoryDto = categoryService.getByCategory(id);

        return  new ResponseEntity<>(categoryDto , HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){

        List<CategoryDto> categories = categoryService.getAllCategory();

        return ResponseEntity.ok(categories);
    }

    @PutMapping("{id}")

    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long id){

        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto,id);

        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<String> deleteCategory(@PathVariable Long id){

        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully!");
    }
}
