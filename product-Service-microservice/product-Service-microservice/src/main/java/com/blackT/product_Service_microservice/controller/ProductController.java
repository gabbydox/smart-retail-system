package com.blackT.product_Service_microservice.controller;

import com.blackT.product_Service_microservice.dto.ProductDto;
import com.blackT.product_Service_microservice.repository.ProductRepository;
import com.blackT.product_Service_microservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/category")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{categoryId}/product")

    public ResponseEntity<ProductDto> saveProduct(@PathVariable Long categoryId,@RequestBody ProductDto productDto){

        ProductDto savedProduct = productService.saveProduct(categoryId,productDto);
        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}/product/{Id}")
        public ResponseEntity<ProductDto> getProductById(@PathVariable Long categoryId,@PathVariable Long Id){

        ProductDto products = productService.getProductById(categoryId, Id);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductDto>> getAllProductsByCategoryId(
            @PathVariable Long categoryId) {

        List<ProductDto> products = productService.getAllProductByCategoryId(categoryId);

        return ResponseEntity.ok(products);
    }

    @PutMapping("/{categoryId}/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long categoryId,
            @PathVariable Long id,
            @RequestBody ProductDto productDto) {

        ProductDto updatedProduct =
                productService.updateProduct(categoryId, id, productDto);

        return ResponseEntity.ok(updatedProduct);
    }


    @DeleteMapping("/{categoryId}/product/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable Long categoryId,
            @PathVariable Long id) {

        productService.deleteProduct(categoryId, id);

        return ResponseEntity.ok("Product deleted successfully!");
    }

}