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

    private String place;

    private String x;
    private String y;
}
