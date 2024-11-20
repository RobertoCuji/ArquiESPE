package ec.edu.espe.taller.repositories;

import ec.edu.espe.taller.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos personalizados si son necesarios
}
