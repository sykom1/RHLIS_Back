package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lis_equipes")
@Data
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "equipes_id")
    private long id;


}
