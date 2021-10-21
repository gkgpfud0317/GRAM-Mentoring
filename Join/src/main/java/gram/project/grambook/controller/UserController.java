package gram.project.grambook.controller;

import gram.project.grambook.dto.JoinDto;
import gram.project.grambook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/join")
    public String join(@RequestBody JoinDto joinDto) {
        return userService.join(joinDto);
    }

    @GetMapping("/user/cheakname")
    public ResponseEntity<Boolean> cheaknameDuplicate(@PathVariable String name) {
        return ResponseEntity.ok(UserService.cheaknameDuplicate(name));
    }

    @GetMapping("/user/userId")
    public ResponseEntity<Boolean> cheakuserIdDuplicate(@PathVariable String userId) {
        return ResponseEntity.ok(UserService.cheakuserIdDuplicate(userId));
    }
}
