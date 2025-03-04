package backend.repositories;

import backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Filtrar por categoria
    List<Product> findByCategory(String category);

    // Filtrar por preço entre dois valores
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    
    // Filtrar por categoria e faixa de preço ao mesmo tempo
    List<Product> findByCategoryAndPriceBetween(String category, Double minPrice, Double maxPrice);

    // Buscar produtos com desconto
    List<Product> findByDiscountGreaterThan(Double discount);

    // Buscar produtos mais vendidos (exemplo: mais de 50 vendas)
    List<Product> findBySoldQuantityGreaterThan(Integer minSold);

    List<Product> findByIsPromotionTrue();
}
