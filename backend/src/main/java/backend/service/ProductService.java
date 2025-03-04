package backend.service;

import backend.models.Product;
import backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        if (StringUtils.hasText(category)) {
            return productRepository.findByCategory(category);
        }
        return List.of();
    }

    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        if (minPrice != null && maxPrice != null && minPrice < maxPrice) {
            return productRepository.findByPriceBetween(minPrice, maxPrice);
        }
        return List.of();
    }

    public List<Product> getProductsByCategoryAndPrice(String category, Double minPrice, Double maxPrice) {
        if (StringUtils.hasText(category) && minPrice != null && maxPrice != null && minPrice < maxPrice) {
            return productRepository.findByCategoryAndPriceBetween(category, minPrice, maxPrice);
        }
        return List.of();
    }

    public List<Product> getPromotions() {
        return productRepository.findByIsPromotionTrue();
    }

    public List<Product> getBestSellers() {
        return productRepository.findBySoldQuantityGreaterThan(50);
    }

    public Page<Product> getProductsPage(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
