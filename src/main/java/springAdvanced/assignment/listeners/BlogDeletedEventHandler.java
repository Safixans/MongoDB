package springAdvanced.assignment.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import springAdvanced.assignment.repo.BlogRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class BlogDeletedEventHandler {
    private final BlogRepository blogRepository;
}
