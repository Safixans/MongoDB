package springAdvanced.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springAdvanced.assignment.entity.Userss;

public interface UserRepository extends JpaRepository<Userss, Integer> {
}
