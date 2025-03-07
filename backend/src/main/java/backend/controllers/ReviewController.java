package backend.controllers;

import backend.models.Reviews;
import backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{id}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Listar todas as avaliações de um produto
    @GetMapping
    public ResponseEntity<List<Reviews>> getReviewsByProductId(@PathVariable Long productId) {
        List<Reviews> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    // Adicionar uma avaliação para um produto
    @PostMapping
    public ResponseEntity<Reviews> addReview(@PathVariable Long productId, @RequestBody Reviews review, @RequestParam Long userId) {
        Reviews newReview = reviewService.addReview(productId, userId, review);
        if (newReview == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(201).body(newReview);
    }
}
