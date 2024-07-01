package springAdvanced.assignment.service;

import springAdvanced.assignment.dtos.BlogDTO;
import springAdvanced.assignment.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog createBlog(BlogDTO blog);

    void updateBlog(Long id, BlogDTO blog);

    void deleteBlog(Long blogId);

    List<Blog> getAllBlogs();
}
