package project_MJ.summer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter

public class Locations {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String x;
    private String y;
}
