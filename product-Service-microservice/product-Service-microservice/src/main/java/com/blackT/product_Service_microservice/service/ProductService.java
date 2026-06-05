package com.blackT.product_Service_microservice.service;


import com.blackT.product_Service_microservice.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductDto saveProduct(Long categoryId,ProductDto productDto);

    ProductDto getProductById(Long categoryId, Long Id);


    List<ProductDto> getAllProductByCategoryId(Long categoryId);

    ProductDto updateProduct(Long categoryId,Long id,ProductDto productDto);

    void deleteProduct(Long categoryId, Long id);
}
