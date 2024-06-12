package springAdvanced.startingLesson.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository bookRepository) {
        this.postRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Post>> getAllPaged(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size,
            @RequestParam(defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam String field
    ) {
//        Sort sort = Sort.by(Sort.Order.asc("postId"));
        Sort sort = Sort.by(direction, field);
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(postRepository.findAll(pageable));
    }

    @GetMapping("/params")
    public ResponseEntity<List<Post>> getAll(
            @RequestParam(defaultValue = "", required = false) String title,
            @RequestParam(defaultValue = "0") int userId) {
//        return ResponseEntity.ok(postRepository.findAllByTitleCustom(title,userId));
        String regex = "^" + title + ".*";
        return ResponseEntity.ok(postRepository.findAllByTitleRegexAndUserIdGreaterThan(regex, userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post book = postRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("not found"));
        return ResponseEntity.ok(book);

    }


    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post book) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postRepository.save(book));

    }


    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Post updatingData) {
        Post book = postRepository
                .findById(updatingData.getPostId())
                .orElseThrow(
                        () -> new RuntimeException("not found"));
        if (updatingData.getTitle() != null) {
            book.setTitle(updatingData.getTitle());
        }
        if (updatingData.getBody() != null) {
            book.setBody(updatingData.getBody());
        }
        if (updatingData.getId() != null) {
            book.setId(updatingData.getId());
        }
        if (updatingData.getUserId() != null) {
            book.setUserId(updatingData.getUserId());
        }

        postRepository.save(book);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Post book = postRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("given post by id is not found and cannot delete"));
        postRepository.delete(book);
        return ResponseEntity.noContent().build();

    }


}
