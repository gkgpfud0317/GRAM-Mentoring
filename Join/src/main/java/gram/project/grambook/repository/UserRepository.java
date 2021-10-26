package gram.project.grambook.repository;

import gram.project.grambook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName = false;
    boolean existsByUserId = false;

    boolean existsByName(String name);

    boolean existsByUserId(String userId);
}
