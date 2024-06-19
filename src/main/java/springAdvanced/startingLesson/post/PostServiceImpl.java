/*package springAdvanced.startingLesson.post;

import lombok.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springAdvanced.startingLesson.post.dtos.CommentCreateDTO;
import springAdvanced.startingLesson.post.dtos.CommentDTO;
import springAdvanced.startingLesson.post.dtos.PostCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostDTO;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO getPost(@NonNull Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post is not found"));

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9595/api/comments/{0}/post";

        ResponseEntity<List<CommentDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<CommentDTO>>() {},
                post.getId()
        );

        List<CommentDTO> comments = response.getBody();

        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .comments(comments)
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

        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }
    @Override
    public Void createComment(@NonNull List<CommentCreateDTO> dtos) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9595/api/comments/saveAll";

        HttpEntity<List<CommentCreateDTO>> request = new HttpEntity<>(dtos);

        ResponseEntity<Void> response = restTemplate.postForEntity(url, request, Void.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return null;
        } else {
            throw new RuntimeException("Failed to create comment");
        }
    }*//*

  */
/*  @Override
    public Void createComment(@NonNull List<CommentCreateDTO> dtos) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/posts/comment";
        restTemplate.postForEntity(url, dtos, Void.class);
        return null;
}
    }*//*



package springAdvanced.startingLesson.post;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import springAdvanced.startingLesson.post.dtos.CommentCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostCreateDTO;
import springAdvanced.startingLesson.post.dtos.PostDTO;
import springAdvanced.startingLesson.resources.CommentResource;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentResource commentResource;


    public PostServiceImpl(PostRepository postRepository, CommentResource commentResource) {


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
                .comments(commentResource.getAllComments(post.getId()))
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
        commentResource.saveAll(dtos);
    }
}
*/
