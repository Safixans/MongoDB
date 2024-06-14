package springAdvanced.startingLesson.post;

import lombok.NonNull;
import springAdvanced.startingLesson.post.dtos.CommentCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO getPost(@NonNull Integer id);

    PostDTO createPost(@NonNull PostCreateDTO postCreateDTO);

    void createComment(@NonNull List<CommentCreateDTO> dtos);
}
