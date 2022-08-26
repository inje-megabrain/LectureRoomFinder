package project_MJ.summer.domain;


import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "\"Users\"")
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "users_id")
    private Long id;

    private String username;
    private String identity;
    private String pw;

    @OneToMany
    @JoinColumn(name = "lecture_room_id")
    private List<LectureRoom> lectureRooms = new ArrayList<>();

    private String lect;

    public Users( String username, String identity, String pw, List<LectureRoom> lectureRooms, String lect) {

        this.username = username;
        this.identity = identity;
        this.pw = pw;
        this.lectureRooms = lectureRooms;
        this.lect = lect;
    }
}
