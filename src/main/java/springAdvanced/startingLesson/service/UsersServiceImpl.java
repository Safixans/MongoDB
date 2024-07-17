package springAdvanced.startingLesson.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springAdvanced.startingLesson.dtos.PostCreateDTO;
import springAdvanced.startingLesson.dtos.PostUpdateDTO;
import springAdvanced.startingLesson.entity.Post;
import springAdvanced.startingLesson.repository.PostRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements PostService {

    private final PostRepository postRepository;


    @Override
    @Transactional
    public Post create(PostCreateDTO dto) {
        return null;
    }

    @Override
    @SneakyThrows // it means there won`t be thrown an exception
    @Cacheable(value = "posts", key = "#id")
    public Post get(Integer id) {

        Post post = postRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("not found by given id"));
        TimeUnit.SECONDS.sleep(1);
        return post;
    }

    @Override
    @CacheEvict(value = "posts", key = "#id")
    public void delete(Integer id) {
        postRepository.deleteById(id);
//        cachedPosts.remove(id);
    }

    @Override
    @CachePut(value = "posts", key = "#dto.id")
    public Post update(PostUpdateDTO dto) {
        Post post = get(dto.getId()); // to increase performance we used get method
                /*postRepository
                .findById(dto.getId())
                .orElseThrow(
                        () -> new RuntimeException("not found by given id"));*/
        post.setTitle(dto.getTitle());
        post.setBody(dto.getBody());
        postRepository.save(post);
//        cachedPosts.put(dto.getId(), post);
        return post;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();

    }
}
