package gram.project.grambook.controller;

import gram.project.grambook.dto.JoinDto;
import gram.project.grambook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/join")
    public void generateToken() {

    }

}

