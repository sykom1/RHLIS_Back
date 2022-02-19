package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lis_pole")
@Data
public class Pole {

    @Id
    @GeneratedValue
    @Column(name = "pole_id")
    private long id;


    @Column(name="poles_label")
    private String name;


    @ManyToMany()
    @JoinTable(
            name = "lis_poles_equipes",
            joinColumns = @JoinColumn(name = "poles_id"),
            inverseJoinColumns = @JoinColumn(name = "teams_id")
    )
    private List<Team> teams;
}
