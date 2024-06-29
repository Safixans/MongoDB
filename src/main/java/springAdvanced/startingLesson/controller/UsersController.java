package springAdvanced.startingLesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.startingLesson.dtos.UsersCreateDTO;
import springAdvanced.startingLesson.entity.Users;
import springAdvanced.startingLesson.mapper.UserMapper;
import springAdvanced.startingLesson.repository.UsersRepository;
import springAdvanced.startingLesson.service.CacheService;
import springAdvanced.startingLesson.service.MailService;
import springAdvanced.startingLesson.service.MailServiceImpl;
import springAdvanced.startingLesson.service.UsersService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final MailService mailService;
    private final CacheService cacheService;

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody UsersCreateDTO dto) {
        return ResponseEntity.status(201).body(usersService.create(dto));
    }

    @PostMapping("/smtp/on-off")
    public ResponseEntity<Boolean> turnOnOrOfSMPTServer() {
        return ResponseEntity.ok(mailService.turnOnOrOfSMPTServer());
    }


    @GetMapping
    public ResponseEntity<ConcurrentHashMap<Object, Map<Object, Object>>> getCache() {

        return ResponseEntity.ok(cacheService.getCache());
    }


}
