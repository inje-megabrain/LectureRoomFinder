package project_MJ.summer.domain;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "\"Users\"")
@Builder
public class Users implements UserDetails{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "users_id")
    private Long id;

    private String username;
    private String identity;
    private String pw;
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();
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
        this.roles = Collections.singletonList("USER");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return getPw();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
