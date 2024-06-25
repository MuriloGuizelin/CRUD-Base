package com.example.springboot.Products;

public interface ProductService {

    public ProductEntity update(Long id, ProductDTO dto);

    public ProductEntity save(ProductDTO dto);
    
}
