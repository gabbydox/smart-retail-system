package com.blackT.product_Service_microservice.service.impl;

import com.blackT.product_Service_microservice.dto.ProductDto;
import com.blackT.product_Service_microservice.entities.Category;
import com.blackT.product_Service_microservice.entities.Product;
import com.blackT.product_Service_microservice.repository.CategoryRepository;
import com.blackT.product_Service_microservice.repository.ProductRepository;
import com.blackT.product_Service_microservice.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl  implements ProductService {

    public   final ProductRepository productRepository;
    public   final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository,ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto saveProduct(Long categoryId, ProductDto productDto) {

        // First, we'll retrieve the Department from the database using the given department ID.
// If the department does not exist, we'll throw a ResourceNotFoundException.

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new RuntimeException("Department not found with id: " + categoryId)
                );

// Second, we'll convert the EmployeeDTO object into an Employee JPA entity.

        Product product = modelMapper.map(productDto, Product.class);

// Third, we'll associate the Employee entity with the retrieved Department entity.

        product.setCategory(category);

// Fourth, we'll save this Employee entity into the database.

        Product savedProduct = productRepository.save(product);

// And finally, we'll convert the saved Employee entity back into an EmployeeDTO object.

        ProductDto savedEmployeeDto = modelMapper.map(savedProduct,ProductDto.class);

        savedEmployeeDto.setCategoryId(categoryId);

        return savedEmployeeDto;
    }

    @Override
    public ProductDto getProductById(Long categoryId, Long Id) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Category not found with id: " + categoryId
                        )
                );

        Product product = productRepository.findById(Id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found with id: " + Id
                        )
                );

        // check product belongs to category
        if (!product.getCategory().getId().equals(category.getId())) {

            throw new RuntimeException(
                    "Product does not belong to category" +categoryId
            );
        }

        // convert entity -> dto
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        productDto.setCategoryId(product.getCategory().getId());

        return productDto;
    }

    @Override
    public List<ProductDto> getAllProductByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException(
                        "Category not found with id: " + categoryId));

        List<Product> products = productRepository.findByCategoryId(categoryId);

        return products.stream()
                .map((Product product) ->
                        modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long categoryId,
                                    Long id,
                                    ProductDto productDto) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Category not found with id: " + categoryId));

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found with id: " + id));

        if (!product.getCategory().getId().equals(category.getId())) {
            throw new RuntimeException(
                    "This product does not belong to category with ID " + categoryId);
        }

        product.setName(productDto.getName());
        product.setBarcode(productDto.getBarcode());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setExpiryDate(productDto.getExpiryDate());

        Product updatedProduct = productRepository.save(product);

        ProductDto savedProductDto =
                modelMapper.map(updatedProduct, ProductDto.class);

        savedProductDto.setCategoryId(categoryId);

        return savedProductDto;
    }

    @Override
    public void deleteProduct(Long categoryId, Long id) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new RuntimeException("Category not found with id: " + categoryId));

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + id));

        if (!product.getCategory().getId().equals(category.getId())) {
            throw new RuntimeException(
                    "This product does not belong to category with ID " + categoryId);
        }

        productRepository.delete(product);
    }

}
