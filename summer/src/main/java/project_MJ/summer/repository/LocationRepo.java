package project_MJ.summer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project_MJ.summer.domain.Locations;

import java.util.List;
import java.util.Optional;

public interface LocationRepo extends JpaRepository<Locations,Long> {

    List<Locations> findByPlaceContaining (String place);

}
