package springAdvanced.assignment.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import springAdvanced.assignment.entity.Blog;

@RequiredArgsConstructor
@Getter
public final class BlogDeletedEvent {
    private final Blog blog;
}
