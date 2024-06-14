package springAdvanced.startingLesson.post;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import springAdvanced.startingLesson.post.dtos.CommentCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostDTO;
import springAdvanced.startingLesson.resources.CommentClient;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentClient commentResource;


    public PostServiceImpl(PostRepository postRepository, CommentClient commentResource) {


        this.postRepository = postRepository;
        this.commentResource = commentResource;
    }

    @Override
    public PostDTO getPost(@NonNull Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post is not found"));


        return PostDTO
                .builder()
                .id(post.getId())
                .title(post.getTitle())
                .comments(commentResource.getAllCommentsByID(post.getId()))
                .body(post.getBody())
                .build();
    }

    @Override
    public PostDTO createPost(@NonNull PostCreateDTO dto) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();
        postRepository.save(post);
        return PostDTO
                .builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

    @Override
    public void createComment(@NonNull List<CommentCreateDTO> dtos) {
        commentResource.saveAllComments(dtos);
    }
}
