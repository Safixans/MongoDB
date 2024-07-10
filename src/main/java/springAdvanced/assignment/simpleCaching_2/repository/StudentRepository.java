package springAdvanced.assignment.simpleCaching_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springAdvanced.assignment.simpleCaching_2.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
