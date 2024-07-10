package springAdvanced.assignment.withRedis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springAdvanced.assignment.withRedis.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
