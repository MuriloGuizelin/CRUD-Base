package com.example.springboot.Products;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    
    private Long id;

    private String name;

    private Integer value;

    private Date date;

}
