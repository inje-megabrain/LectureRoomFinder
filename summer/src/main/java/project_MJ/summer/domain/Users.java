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

public class Users {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String username;
    private String identity;
    private String pw;
    @OneToMany(targetEntity = LectureRoom.class,fetch = FetchType.LAZY)
    private Collection<LectureRoom> lectureRooms = new ArrayList<>();
    private String lect;
}
