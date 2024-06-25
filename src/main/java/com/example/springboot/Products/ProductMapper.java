package com.example.springboot.Products;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "value", source = "value")
    ProductEntity toEntity(ProductDTO dto);

}
