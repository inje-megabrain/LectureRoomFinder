package project_MJ.summer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_MJ.summer.domain.Users;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByIdentity(String identity);
}
