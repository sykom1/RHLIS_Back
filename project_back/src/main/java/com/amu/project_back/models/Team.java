package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lis_equipes")
@Data
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "equipes_id")
    private long id;

    @Column(name = "equipes_label")
    private String label;

    @Column(name = "equipes_nom_long")
    private String longName;

    @ManyToMany(mappedBy="teams")
    private List<Pole> poles;




}
