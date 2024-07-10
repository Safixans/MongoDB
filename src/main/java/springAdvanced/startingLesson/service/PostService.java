package springAdvanced.startingLesson.service;

import org.springframework.stereotype.Service;
import springAdvanced.startingLesson.dtos.PostCreateDTO;
import springAdvanced.startingLesson.dtos.PostUpdateDTO;
import springAdvanced.startingLesson.entity.Post;


@Service
public interface PostService {
    Post create(PostCreateDTO dto);

    Post get(Integer id);
    void delete(Integer id);
    void update(PostUpdateDTO dto);
}
