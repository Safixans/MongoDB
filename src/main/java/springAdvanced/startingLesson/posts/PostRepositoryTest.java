package springAdvanced.startingLesson.posts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class PostRepositoryTest {
    public static void main(String[] args) throws IOException {
        PostRepositoryImpl postRepository = new PostRepositoryImpl();


        Post post = Post.builder()
                .id(200)
                .mongoID(new ObjectId("6668245504af3336be04bdeb"))
                .userId(210)
                .title("Post title")
                .body("Post body")
                .build();
        Post savedPost = postRepository.save(post);
        System.out.println("savedPost = " + savedPost);

       /* URL url = new URL("https://jsonplaceholder.typicode.com/posts");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Post> posts = objectMapper.readValue(url, new TypeReference<>() {});
        List<Post> savedPosts = postRepository.saveAll(posts);
        for (Post savedPost1 : savedPosts) {
            System.out.println("savedPost1 = " + savedPost1);
        }*/
//        System.out.println(postRepository.delete("6668245404af3336be04bdea"));
//        System.out.println(postRepository.update(post));
        postRepository.getAll(0,100).forEach(System.out::println);

    }
}
