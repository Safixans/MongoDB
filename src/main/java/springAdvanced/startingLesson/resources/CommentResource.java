package springAdvanced.startingLesson.resources;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import springAdvanced.startingLesson.post.dtos.CommentCreateDTO;
import springAdvanced.startingLesson.post.dtos.CommentDTO;

import java.util.Collections;
import java.util.List;

@Service
public class CommentResource {
    @Value("${comments.url.postComments}")
    private String postCommentsURL;
    @Value("${comments.url.saveComments}")
    private String saveCommentsURL;

    private final RestTemplate restTemplate;

    public CommentResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CommentDTO> getAllComments(@NonNull Integer postId) {

//        String url = "http://localhost:9595/api/comments/{0}/post"; tepadigini ishlatamiz endi buni orniga
        // ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class, post.getId());
        //List comments = responseEntity.getBody();
        //  ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class, post.getId());
        // List comments = restTemplate.getForObject(url, List.class, post.getId());

        //this is for an example of headers nothing special
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("authentication", "Bearer token...............");
//        headers.setBearerAuth("token");
//        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
//        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(new Object(), headers);
        try {
            ResponseEntity<List<CommentDTO>> response = restTemplate.exchange(
                    postCommentsURL,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<>() {
                    },
                    postId
            );
            return response.getBody();
        } catch (ResourceAccessException e) {
            e.printStackTrace();
        }
            return Collections.emptyList();
    }

    public void saveAll(List<CommentCreateDTO> commentCreateDTOS) {
//        String url = "http://localhost:9595/api/comments/saveAll";
        HttpEntity<List<CommentCreateDTO>> httpEntity = new HttpEntity<>(commentCreateDTOS);
        restTemplate.exchange(saveCommentsURL, HttpMethod.POST, httpEntity, Void.class);
    }
}
