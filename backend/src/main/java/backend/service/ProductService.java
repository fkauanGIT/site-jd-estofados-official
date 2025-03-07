package backend.service;

import backend.models.Products;
import backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // GET: Retorna todos os produtos
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    // GET: Retorna produtos por categoria
    public List<Products> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // GET: Retorna produtos por faixa de preço
    public List<Products> getProductsByPriceRange(Double min, Double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    // GET: Retorna produtos que contêm o nome especificado (busca ignorando maiúsculas/minúsculas)
    public List<Products> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    // GET: Retorna produtos em promoção
    public List<Products> getPromotions() {
        return productRepository.findByIsPromotionTrue();
    }

    // GET: Retorna os 10 produtos mais vendidos (ordenados por quantidade vendida)
    public List<Products> getBestSellers() {
        return productRepository.findBySoldQuantityGreaterThan(10);
    }

    // GET: Retorna um produto pelo ID
    public Optional<Products> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // POST: Salva um novo produto
    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    // POST: Salva uma lista de produtos
    public List<Products> saveProducts(List<Products> products) {
        return productRepository.saveAll(products);
    }

    // DELETE: Deleta um produto pelo ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    // DELETE: Deleta todos os produtos
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    // PUT: Atualiza um produto existente pelo ID
    public Products updateProductById(Long id, Products updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    // Atualiza apenas os campos não nulos
                    if (updatedProduct.getName() != null) {
                        product.setName(updatedProduct.getName());
                    }
                    if (updatedProduct.getDescription() != null) {
                        product.setDescription(updatedProduct.getDescription());
                    }
                    if (updatedProduct.getPrice() != null) {
                        product.setPrice(updatedProduct.getPrice());
                    }
                    if (updatedProduct.getCategory() != null) {
                        product.setCategory(updatedProduct.getCategory());
                    }
                    if (updatedProduct.getImageUrl() != null) {
                        product.setImageUrl(updatedProduct.getImageUrl());
                    }
                    if (updatedProduct.getStatus() != null) {
                        product.setStatus(updatedProduct.getStatus());
                    }
                    if (updatedProduct.getIsPromotion() != null) {
                        product.setIsPromotion(updatedProduct.getIsPromotion());
                    }
                    if (updatedProduct.getDiscount() != null) {
                        product.setDiscount(updatedProduct.getDiscount());
                    }
                    if (updatedProduct.getSoldQuantity() != null) {
                        product.setSoldQuantity(updatedProduct.getSoldQuantity());
                    }
                    return productRepository.save(product); // Salva as alterações
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }
}