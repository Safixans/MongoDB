package springAdvanced.startingLesson.resources;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.client.RestTemplate;


import springAdvanced.startingLesson.post.dtos.CommentCreateDTO;
import springAdvanced.startingLesson.post.dtos.CommentDTO;

import java.util.List;

@Service
public class CommentResource {
    @Value("${comments.url.postComments}")
    private String postCommentsURL;
    @Value("${comments.url.saveComments}")
    private String saveCommentsURL;

    private final RestTemplate restTemplate;
    private final WebClient webClient;


    public CommentResource(RestTemplate restTemplate, WebClient webClient) {
        this.restTemplate = restTemplate;
        this.webClient = webClient;
    }

    public List<CommentDTO> getAllComments(@NonNull Integer postId) {

        return webClient.get()
                .uri(postCommentsURL,postId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CommentDTO>>() {})
                .block();// WebClient default it requests asynchroun request when we write block() -> it requests synchronous requests that we need is synchronous
    }

    public void saveAll(List<CommentCreateDTO> commentCreateDTOS) {
//        String url = "http://localhost:9595/api/comments/saveAll";

        webClient.post()
                .uri(saveCommentsURL)
                .body(BodyInserters.fromValue(commentCreateDTOS))
                .retrieve()
                .bodyToMono(Void.class)
                .block();

    }
}
