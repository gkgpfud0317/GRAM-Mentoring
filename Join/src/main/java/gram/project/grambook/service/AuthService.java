package gram.project.grambook.service;

import gram.project.grambook.dto.JoinDto;
import gram.project.grambook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
}
