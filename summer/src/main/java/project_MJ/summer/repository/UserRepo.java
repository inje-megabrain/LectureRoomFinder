package project_MJ.summer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_MJ.summer.domain.Users;

public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByName (String name);
}
