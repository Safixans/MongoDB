package springAdvanced.assignment.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import springAdvanced.assignment.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
