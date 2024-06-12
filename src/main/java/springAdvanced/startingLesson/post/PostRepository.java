package springAdvanced.startingLesson.post;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    /*@Query("{ 'post_title' : { $regex : '^?0.*' }, userId : { $gt: ?1 } }")
    List<Post> findAllByTitleCustom(String title, Integer id);*/

    List<Post> findAllByTitleRegexAndUserIdGreaterThan(String regex, int userId);



}
