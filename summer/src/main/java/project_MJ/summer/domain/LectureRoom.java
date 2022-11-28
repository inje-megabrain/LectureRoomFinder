package project_MJ.summer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class LectureRoom {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "lecture_room_id")
    private Long id;


    private String startTime; // 수업 시작 시간
    private String endTime; // 수업 마칠 시간

    private String search; //입력 받는 위치

    @OneToOne
    @JoinColumn(name = "locations_id")
    private Locations locations;

    public LectureRoom(String startTime, String endTime, String search, Locations locations) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.search = search;
        this.locations = locations;
    }
}
