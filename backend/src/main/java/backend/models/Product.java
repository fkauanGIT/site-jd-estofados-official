package backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false, columnDefinition = "DOUBLE DEFAULT 0.0")
    private Double price = 0.0;

    private String category;
    private String status;
    private String image_url;
    private Boolean isPromotion = false;

    @Column(columnDefinition = "DOUBLE DEFAULT 0.0")
    private Double discount = 0.0;

    @Column(name = "sold_quantity", columnDefinition = "INTEGER DEFAULT 0")
    private Integer soldQuantity = 0;
}
