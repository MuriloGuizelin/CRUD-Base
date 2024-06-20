package com.example.springboot.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Exceptions.Exception400;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO update(Long id, ProductDTO dto) {
        ProductEntity existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new Exception400("Product not found"));

        existingProduct.setName(dto.getName());
        existingProduct.setValue(dto.getValue());

        productRepository.save(existingProduct);

        return dto;
    }
}
