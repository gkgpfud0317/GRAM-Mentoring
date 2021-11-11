package gram.project.grambook.repository;

import gram.project.grambook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByName = false;
    boolean existsByUserId = false;

    boolean existsByName(String name);

    boolean existsByUserId(String userId);
}
