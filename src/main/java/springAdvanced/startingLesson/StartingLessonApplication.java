package springAdvanced.startingLesson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import springAdvanced.startingLesson.entity.Post;
import springAdvanced.startingLesson.repository.PostRepository;

import java.net.URL;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableCaching
public class StartingLessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartingLessonApplication.class, args);
    }


    @Bean
    public ApplicationRunner init(ObjectMapper objectMapper, PostRepository postRepository) {
        return args -> {
            List<Post> posts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<List<Post>>() {});
            postRepository.saveAll(posts);
        };
    }

    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(Collections.singleton("posts"));
        return cacheManager;
    }

}
