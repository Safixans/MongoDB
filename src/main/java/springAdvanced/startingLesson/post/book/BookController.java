package springAdvanced.startingLesson.post.book;


import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.startingLesson.post.Post;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

  /*  @GetMapping("/paged")
    public ResponseEntity<Page<Post>> getAllPaged(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size,
            @RequestParam(defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam String field
    ) {
//        Sort sort = Sort.by(Sort.Order.asc("postId"));
        Sort sort = Sort.by(direction, field);
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }*/
/*
    @GetMapping("/query")
    public ResponseEntity<List<Post>> getAll(
            @RequestParam(defaultValue = "", required = false) String title,
            @RequestParam(defaultValue = "0") int userId) {
//        return ResponseEntity.ok(postRepository.findAllByTitleCustom(title,userId));
        String regex = "^" + title + ".*";
        return ResponseEntity.ok(bookRepository.findAllByTitleRegexAndUserIdGreaterThan(regex, userId));
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable String id) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("not found"));
        return ResponseEntity.ok(book);

    }


    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookRepository.save(book));

    }


    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody Book updatingData) {
        return ResponseEntity.ok(bookRepository.update(updatingData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        bookRepository.delete(new ObjectId(id));
        return ResponseEntity.noContent().build();

    }


}
