package backend.repositories;

import backend.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    // GET: Retorna produtos filtrados por categoria
    List<Products> findByCategory(String category);

    // GET: Retorna produtos filtrados por faixa de preço (entre um valor mínimo e máximo)
    List<Products> findByPriceBetween(Double minPrice, Double maxPrice);

    // GET: Retorna produtos com quantidade vendida maior que o valor especificado
    List<Products> findBySoldQuantityGreaterThan(Integer minSold);

    // GET: Retorna produtos em promoção
    List<Products> findByIsPromotionTrue();

    // GET: Retorna produtos que contêm o nome especificado (ignorando maiúsculas/minúsculas)
    List<Products> findByNameContainingIgnoreCase(String name);
}