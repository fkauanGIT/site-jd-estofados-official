package backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price = 0.0;

    @Column(nullable = false)
    private String category;

    private String status;

    @Column(nullable = false)
    private String imageUrl;

    private Boolean isPromotion = false;

    private Double discount = 0.0;

    private Integer soldQuantity = 0;

    @PrePersist
    @PreUpdate
    public void validatePrice() {
        if(price < 0){
            throw new IllegalArgumentException("Valores negativos não são aceitos");
        }
    }
}
