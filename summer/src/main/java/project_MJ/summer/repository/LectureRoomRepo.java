package project_MJ.summer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_MJ.summer.domain.LectureRoom;

public interface LectureRoomRepo extends JpaRepository<LectureRoom,Long> {
    LectureRoom findBySearch (String search);
}
