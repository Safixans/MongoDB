package springAdvanced.startingLesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springAdvanced.startingLesson.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}