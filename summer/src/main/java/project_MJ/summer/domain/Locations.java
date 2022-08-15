package project_MJ.summer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Locations {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @ElementCollection(targetClass=String.class)
    private List<String> list = new ArrayList<>();

    private String x;
    private String y;

    public Locations(Long id, String x, String y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}
