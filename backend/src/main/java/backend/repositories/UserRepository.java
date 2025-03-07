package backend.repositories;

import backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}
