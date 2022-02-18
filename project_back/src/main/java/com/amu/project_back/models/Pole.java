package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lis_pole")
@Data
public class Pole {

    @Id
    @GeneratedValue
    @Column(name = "pole_id")
    private long id;


    @Column(name="poles_label")
    private String label;

    /*
    @OneToOne
    @JoinColumn(name="equipes_id")
    private transient Team team;
    */
}
