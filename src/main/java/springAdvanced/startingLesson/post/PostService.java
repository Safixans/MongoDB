package springAdvanced.startingLesson.post;

import lombok.NonNull;

import java.net.URISyntaxException;

public interface PostService {
    Post getPost(@NonNull Integer id) throws URISyntaxException;

}
