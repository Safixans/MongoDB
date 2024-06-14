package springAdvanced.startingLesson.resources;


import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.MediaTypes;
import org.springframework.stereotype.Service;
import springAdvanced.startingLesson.post.Post;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@Slf4j
public class CommentResource {

    @Value("${hateoas.url.base}")
    private String baseURL;


    public Post getPost(@NonNull Integer id) throws URISyntaxException {
        Traverson traverson = new Traverson(new URI(baseURL + id), MediaTypes.HAL_JSON);
        //CollectionModel<EntityModel<Post>>
        EntityModel<Post> entityModel = traverson.follow("self")
                .toObject(new ParameterizedTypeReference<EntityModel<Post>>() {
                });
        if (entityModel == null)
            return null;

        for (Link link : entityModel.getLinks())
            log.info("links from Hateoas API: " + link);

        return entityModel.getContent();

    }
}
