package springAdvanced.assignment.userController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springAdvanced.assignment.dtos.UserCreateDTO;
import springAdvanced.assignment.dtos.UserUpdateDTO;
import springAdvanced.assignment.entity.Userss;
import springAdvanced.assignment.service.EmailSenderService;
import springAdvanced.assignment.service.UserCacheService;
import springAdvanced.assignment.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/user/controller")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EmailSenderService emailSenderService;
    private final UserCacheService userCacheService;

    @PostMapping("/create")
    public ResponseEntity<Userss> create(@RequestBody UserCreateDTO dto) {
        return ResponseEntity.status(201).body(userService.createUser(dto));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Userss> update(@PathVariable Integer id, @RequestBody UserUpdateDTO dto) {
        return ResponseEntity.status(201).body(userService.updateUser(id, dto));
    }

    @PostMapping("/smtp/on-off")
    public ResponseEntity<Boolean> turnOnOrOfSMPTServer() {
        return ResponseEntity.ok(emailSenderService.turnOnOrOfSMPTServer());
    }


    @GetMapping
    public ResponseEntity<ConcurrentHashMap<Object, Map<Object, Object>>> getCache() {

        return ResponseEntity.ok(userCacheService.getCache());
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Userss>> getUserss() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Void> getUserss(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
