package ec.edu.espe.taller.repositories;

import ec.edu.espe.taller.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Métodos personalizados si son necesarios
}
