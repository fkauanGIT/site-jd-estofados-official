package backend.controllers;

import backend.models.Product;
import backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Listar todos os produtos
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Filtrar produtos por categoria
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    // Filtrar produtos por faixa de preço
    @GetMapping("/price")
    public List<Product> getProductsByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return productService.getProductsByPriceRange(min, max);
    }

    // Filtrar produtos por categoria e preço ao mesmo tempo
    @GetMapping("/filter")
    public List<Product> getProductsByCategoryAndPrice(
        @RequestParam String category,
        @RequestParam Double min,
        @RequestParam Double max
    ) {
        return productService.getProductsByCategoryAndPrice(category, min, max);
    }

    // Produtos em promoção
    @GetMapping("/promotions")
    public List<Product> getPromotions() {
        return productService.getPromotions();  // Chama o serviço que retorna produtos com promoção
    }

    // Produtos mais vendidos
    @GetMapping("/bestsellers")
    public List<Product> getBestSellers() {
        return productService.getBestSellers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
