package springAdvanced.startingLesson.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import springAdvanced.startingLesson.post.dtos.CommentCreateDTO;
import springAdvanced.startingLesson.post.dtos.CommentDTO;

import java.util.List;

@FeignClient(value = "CommentClient", url = "${comments.url.base}")
public interface CommentClient {

    @GetMapping("/{id}/posts/")
    List<CommentDTO> getAllCommentsByID(@PathVariable Integer id);

    @PostMapping("/saveAll")
    void saveAllComments(@RequestBody List<CommentCreateDTO> dtos);

}
