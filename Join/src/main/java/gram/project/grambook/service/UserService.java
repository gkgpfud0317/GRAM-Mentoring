package gram.project.grambook.service;

import gram.project.grambook.dto.JoinDto;
import gram.project.grambook.entity.User;
import gram.project.grambook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<String> cheakuserIdDuplicate(String userId) {

        userRepository.existsByuserID(userId);

        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
    }

    public ResponseEntity<String> cheaknameDuplicate(String name) {

        userRepository.existsByname(name);

        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
    }

    public String join(JoinDto joinDto) {

        userRepository.save(User.builder()
                .name(joinDto.getName())
                .userId(joinDto.getUserId())
                .password(bCryptPasswordEncoder.encode(joinDto.getPassword()))
                .build());

        return "Success";
    }
}
