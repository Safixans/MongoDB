package springAdvanced.startingLesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springAdvanced.startingLesson.entity.Post;


public interface PostRepository extends JpaRepository<Post, Integer> {
}