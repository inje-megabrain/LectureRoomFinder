package project_MJ.summer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_MJ.summer.domain.Locations;

public interface LocationRepo extends JpaRepository<Locations,Long> {
    Locations findByName (String name);
}
