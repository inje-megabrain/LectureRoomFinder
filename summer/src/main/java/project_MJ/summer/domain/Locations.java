package project_MJ.summer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Locations {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "locations_id")
    private Long id;


    private String place;
    private String x;
    private String y;

    public Locations(String place, String x, String y) {
        this.place = place;
        this.x = x;
        this.y = y;
    }
}
