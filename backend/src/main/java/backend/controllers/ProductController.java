package backend.controllers;

import backend.models.Products;
import backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET: Retorna todos os produtos
    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // GET: Retorna produtos filtrados por categoria
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Products>> getProductsByCategory(@PathVariable String category) {
        List<Products> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    // GET: Retorna produtos filtrados por faixa de preço
    @GetMapping("/price")
    public ResponseEntity<List<Products>> getProductsByPriceRange(
            @RequestParam Double min, 
            @RequestParam Double max) {
        List<Products> products = productService.getProductsByPriceRange(min, max);
        return ResponseEntity.ok(products);
    }

    // GET: Retorna produtos que contêm o nome especificado (busca ignorando maiúsculas/minúsculas)
    @GetMapping("/search")
    public ResponseEntity<List<Products>> searchProductsByName(@RequestParam String name) {
        List<Products> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);
    }

    // GET: Retorna produtos em promoção
    @GetMapping("/promotions")
    public ResponseEntity<List<Products>> getPromotions() {
        List<Products> products = productService.getPromotions();
        return ResponseEntity.ok(products);
    }

    // GET: Retorna os 10 produtos mais vendidos (ordenados por quantidade vendida)
    @GetMapping("/bestsellers")
    public ResponseEntity<List<Products>> getBestSellers() {
        List<Products> products = productService.getBestSellers();
        return ResponseEntity.ok(products);
    }

    // GET: Retorna um produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Cria um novo produto
    @PostMapping("/newProduct")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // POST: Cria vários produtos
    @PostMapping("/newProducts")
    public ResponseEntity<List<Products>> createProducts(@RequestBody List<Products> products) {
        List<Products> savedProducts = productService.saveProducts(products);
        return ResponseEntity.ok(savedProducts);
    }

    // DELETE: Deleta um produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

    // DELETE: Deleta todos os produtos
    @DeleteMapping
    public ResponseEntity<Void> deleteAllProducts() {
        productService.deleteAllProducts();
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

    // PUT: Atualiza um produto existente pelo ID
    @PutMapping("/editProduct/{id}")
    public ResponseEntity<Products> updateProductById(
            @PathVariable Long id,
            @RequestBody @Validated Products updatedProduct) { // Adicione @Valid para validação
        Products product = productService.updateProductById(id, updatedProduct);
        return ResponseEntity.ok(product); // Retorna o produto atualizado
    }
}