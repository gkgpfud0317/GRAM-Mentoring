package gram.project.grambook.controller;

import gram.project.grambook.dto.JoinDto;
import gram.project.grambook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody JoinDto joinDto) {
        return userService.join(joinDto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<String> checkNameDuplicate(@PathVariable String name) {
        return userService.checkNameDuplicate(name);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<String> checkUserIdDuplicate(@PathVariable String userId) {
        return userService.checkUserIdDuplicate(userId);
    }
}
