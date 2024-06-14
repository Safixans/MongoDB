package springAdvanced.startingLesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


import java.time.Duration;


@SpringBootApplication
@EnableFeignClients
public class StartingLessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartingLessonApplication.class, args);
    }

}
