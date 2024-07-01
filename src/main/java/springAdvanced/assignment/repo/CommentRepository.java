package springAdvanced.assignment.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import springAdvanced.assignment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
