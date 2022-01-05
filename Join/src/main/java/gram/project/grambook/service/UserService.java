package gram.project.grambook.service;

import gram.project.grambook.dto.JoinDto;
import gram.project.grambook.entity.User;
import gram.project.grambook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<String> checkUserIdDuplicate(String userId) {
        if(userRepository.existsByUserId(userId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User Already Exists");
        }

        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
    }

    public ResponseEntity<String> checkNameDuplicate(String name) {
        if(userRepository.existsByName(name)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User Already Exists");
        }

        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
    }

    public String join(JoinDto joinDto) {

        userRepository.save(User.builder()
                .name(joinDto.getName())
                .userId(joinDto.getUserId())
                .password(passwordEncoder.encode(joinDto.getPassword()))
                .build());

        return "Success";
    }
}
