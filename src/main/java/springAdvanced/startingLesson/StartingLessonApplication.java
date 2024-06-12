package springAdvanced.startingLesson;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.MapMapping;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import springAdvanced.startingLesson.post.Post;
import springAdvanced.startingLesson.post.PostRepository;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableMongoAuditing
public class StartingLessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartingLessonApplication.class, args);
    }


  /*  @Bean
    public AuditorAware<Long> auditorAware() { // createdBY and updatedBy fields should aware of which id or who updated or created
        return () -> Optional.of(1L);
    }*/

    /*@Bean*/
   /* public ApplicationRunner applicationRunner(
            ObjectMapper objectMapper,
            PostRepository bookRepository
    ) {
        return args -> {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            List<Post> books = objectMapper.readValue(url, new TypeReference<List<Post>>() {
            });
            bookRepository.saveAll(books);
        };

    }*/
}
