package springAdvanced.assignment.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springAdvanced.assignment.dtos.BlogDTO;
import springAdvanced.assignment.entity.Blog;
import springAdvanced.assignment.mappers.BlogMapper;
import springAdvanced.assignment.repo.BlogRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional
    public Blog createBlog(@NonNull BlogDTO blog) {
        Blog blog1 = blogMapper.fromBlogCreateDTO(blog);
        log.info("Creating blog: {}", blog1.toString());
        return blogRepository.save(blog1);


    }

    @Override
    @Transactional
    public void updateBlog(@NonNull Long id, BlogDTO dto) {
        log.info("Updating blog with id: " + id);
        Blog blog1 = blogRepository.findById(id).orElseThrow();
        blog1.setTitle(dto.getTitle());
        blog1.setDescription(dto.getDescription());

        blogRepository.save(blog1);
        log.info("Updated blog successfully with id: " + id);
    }

    @Override
    public void deleteBlog(Long blogId) {

    }

    @Override
    public List<Blog> getAllBlogs() {
        return List.of();
    }
}
