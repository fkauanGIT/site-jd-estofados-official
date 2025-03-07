package backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.models.Products;
import backend.models.Reviews;
import backend.models.Users;
import backend.repositories.ProductRepository;
import backend.repositories.ReviewRepository;
import backend.repositories.UserRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Reviews addReview(Long productId, Long userId, Reviews review) {
        Optional<Products> product = productRepository.findById(productId);
        Optional<Users> user = userRepository.findById(userId);

        if (product.isPresent() && user.isPresent()) {
            review.setProduct(product.get());
            review.setUser(user.get());
            return reviewRepository.save(review);
        }

        return null; // Produto ou usuário não encontrados
    }

    public List<Reviews> getReviewsByProductId(Long productId) {
        Optional<Products> product = productRepository.findById(productId);
        
        if (product.isPresent()) {
            return reviewRepository.findByProduct(product.get());
        }
        return List.of(); // Retorna lista vazia caso o produto não seja encontrado
    }
}
