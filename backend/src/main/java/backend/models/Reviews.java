package backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)  // Chave estrangeira para Products
    private Products product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Chave estrangeira para Users
    private Users user;
}
