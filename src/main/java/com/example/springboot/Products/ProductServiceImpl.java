package com.example.springboot.Products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Exceptions.Exception400;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity update(Long id, ProductDTO dto) {
        ProductEntity existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new Exception400("Product not found"));

        productRepository.save(existingProduct);

        return existingProduct;
    }

    @Override
    public ProductEntity save(ProductDTO dto) {
        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(dto.getName());
            productEntity.setValue(dto.getValue());
            productEntity.setDate(dto.getDate());

            return productRepository.save(productEntity);
        } catch (Exception e) {
            throw new Exception400("Failed to save product");
        }
    }

}
