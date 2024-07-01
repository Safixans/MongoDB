package springAdvanced.assignment.service;

import springAdvanced.assignment.dtos.BlogDTO;
import springAdvanced.assignment.dtos.CommentDTO;
import springAdvanced.assignment.entity.Blog;
import springAdvanced.assignment.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(CommentDTO dto);

    void updateComment(Long id, CommentDTO dto);

    void deleteComment(Long blogId);

    List<Blog> getAllBlogs();
}
