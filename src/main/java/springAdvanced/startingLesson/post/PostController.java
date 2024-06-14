package springAdvanced.startingLesson.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@Slf4j
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}/posts")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity.ok(postService.getPost(id));
    }


}

