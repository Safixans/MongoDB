package springAdvanced.assignment.withConcurrentHashMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springAdvanced.assignment.withConcurrentHashMap.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {
}
