package springAdvanced.startingLesson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springAdvanced.startingLesson.entity.Post;
import springAdvanced.startingLesson.repository.PostRepository;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableCaching
@EnableScheduling
public class StartingLessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartingLessonApplication.class, args);
    }


    @Bean
    public ApplicationRunner init(ObjectMapper objectMapper, PostRepository postRepository) {
        return args -> {
            List<Post> posts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<List<Post>>() {
            });
            postRepository.saveAll(posts);
        };
    }

}
