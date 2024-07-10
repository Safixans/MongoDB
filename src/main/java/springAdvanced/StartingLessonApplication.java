package springAdvanced;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

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

/*

    @Bean
    public ApplicationRunner init(ObjectMapper objectMapper, PostRepository postRepository) {
        return args -> {
            List<Post> posts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<List<Post>>() {
            });
            postRepository.saveAll(posts);
        };
    }
*/

    @Bean
    public CaffeineCacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("students");
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .weakKeys()
                .recordStats();
    }
}
