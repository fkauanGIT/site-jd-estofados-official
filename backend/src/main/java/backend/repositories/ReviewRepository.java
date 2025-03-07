package backend.repositories;

import backend.models.Reviews;
import backend.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    List<Reviews> findByProduct(Products product); // Busca avaliações pelo produto
}
