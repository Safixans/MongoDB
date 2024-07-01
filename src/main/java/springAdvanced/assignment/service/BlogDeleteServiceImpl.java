package springAdvanced.assignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springAdvanced.assignment.entity.Blog;
import springAdvanced.assignment.repo.BlogRepository;

@Service
@RequiredArgsConstructor
public class BlogDeleteServiceImpl implements CommentDeletedWhenBlogDeletedService{
    private final BlogRepository blogRepository;

    @Override
    public void deleteBlog(Blog blog) {

    }
}
