package springAdvanced.startingLesson.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springAdvanced.startingLesson.resources.CommentResource;

import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final CommentResource commentResource;

    @Override
    public Post getPost(@NonNull Integer id) throws URISyntaxException {
        return commentResource.getPost(id);
    }

}
