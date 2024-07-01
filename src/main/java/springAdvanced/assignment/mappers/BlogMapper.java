package springAdvanced.assignment.mappers;

import org.mapstruct.Mapper;
import springAdvanced.assignment.dtos.BlogDTO;
import springAdvanced.assignment.entity.Blog;

@Mapper(componentModel = "spring")
public interface BlogMapper {
    Blog fromBlogCreateDTO(BlogDTO dto);

    BlogDTO fromBlogToBlogDTO(Blog blog);
}
