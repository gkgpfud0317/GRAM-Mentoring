package gram.project.grambook.repository;

import gram.project.grambook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByname = false;
    boolean existsByUserId = false;

    boolean existsByname(String name);

    boolean existsByuserID(String userId);
}
