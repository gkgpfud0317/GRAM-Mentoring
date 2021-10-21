package gram.project.grambook.service;

import gram.project.grambook.dto.JoinDto;
import gram.project.grambook.entity.User;
import gram.project.grambook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean cheakuserIdDuplicate(String userId) {
        return userRepository.existsByuserID(userId);
    }

    public boolean cheaknameDuplicate(String name) {
        return userRepository.existsByname(name);
    }

    public String join(JoinDto joinDto) {
        User user = User.builder()
                .name(joinDto.getName())
                .userId(joinDto.getUserId())
                .password(bCryptPasswordEncoder.encode(joinDto.getPassword()))
                .build();
        userRepository.save(user);
        return "Success";
    }
}
