package project_MJ.summer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class LectureRoom {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String startTime; // 수업 시작 시간
    private String endTime; // 수업 마칠 시간

    private String search; //입력 받는 위치
    @OneToMany(targetEntity = LectureRoom.class,fetch = FetchType.LAZY)
    private Collection<Locations> locations = new ArrayList<>();
}
