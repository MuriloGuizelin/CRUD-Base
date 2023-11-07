# API para realizar o protocolo HTTP de produtos.

Um CRUD funcional em SpringBoot, usando Postgres como banco de dados.

Usando apenas 3 valores base para criar o objeto (ID, Name, Value).

Protocolo REST:

## GET:
`@GetMapping("/products")
	public ResponseEntity<List<ProductEntity>> getAllProducts(){
		List<ProductEntity> productsList = productRepository.findAll();
		if(!productsList.isEmpty()) {
			for(ProductEntity product : productsList) {
				UUID id = product.getIdProduct();
				product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(productsList);
	}`

## POST:
`@PostMapping("/products")
	public ResponseEntity<ProductEntity> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
		var productModel = new ProductEntity();
		BeanUtils.copyProperties(productRecordDto, productModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
	}`

## DELETE:
`@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
		Optional<ProductEntity> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		productRepository.delete(productO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}`

 ## PUT:
 `PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto) {
		Optional<ProductEntity> productO = productRepository.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		var productModel = productO.get();
		BeanUtils.copyProperties(productRecordDto, productModel);
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
	}`


> [!NOTE]
> Esse é um projeto pessoal que pode estar com erros de sintaxe e lógica.
