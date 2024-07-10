package springAdvanced.startingLesson.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springAdvanced.startingLesson.dtos.PostCreateDTO;
import springAdvanced.startingLesson.dtos.PostUpdateDTO;
import springAdvanced.startingLesson.entity.Post;
import springAdvanced.startingLesson.repository.PostRepository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements PostService {

    private final ConcurrentHashMap<Integer, Post> cachedPosts = new ConcurrentHashMap<>();
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Post create(PostCreateDTO dto) {
        return null;
    }

    @Override
    @SneakyThrows // it means there won`t be thrown an exception
    public Post get(Integer id) {
        Post postCached = cachedPosts.get(id);
        if (postCached != null) {
            return postCached;
        }

        Post post = postRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("not found by given id"));
        TimeUnit.SECONDS.sleep(1);

        cachedPosts.put(id, post);
        return post;
    }

    @Override
    public void delete(Integer id) {
        postRepository.deleteById(id);
        cachedPosts.remove(id);
    }

    @Override
    public void update(PostUpdateDTO dto) {
        Post post = get(dto.getId()); // to increase performance we used get method
                /*postRepository
                .findById(dto.getId())
                .orElseThrow(
                        () -> new RuntimeException("not found by given id"));*/
        post.setTitle(dto.getTitle());
        post.setBody(dto.getBody());
        postRepository.save(post);
        cachedPosts.put(dto.getId(), post);
    }
}
