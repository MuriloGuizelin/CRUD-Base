package com.example.springboot.Products;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.Exceptions.Exception400;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<Object> indexProducts(){
		return ResponseEntity.ok(productRepository.findAll());
		
	}

	@PostMapping("/save")
	public ResponseEntity<Object> saveProduct(@Valid @RequestBody ProductDTO dto){
		return ResponseEntity.ok(productService.save(dto));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Long id){

		if(!productRepository.existsById(id)){
			throw new Exception400("Produto não encontrado.");
		}
		
		productRepository.deleteById(id);
		return ResponseEntity.ok("Deletado com sucesso.");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO dto){
		
		return ResponseEntity.ok(productService.update(id, dto));	
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Object> findProduct(@PathVariable Long id){
		if(!productRepository.existsById(id)){
			throw new Exception400("Produto não encontrado.");
		}
		return ResponseEntity.ok(productRepository.findById(id));
	}

}
