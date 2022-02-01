package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "utilisateurs")
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name = "uti_id")
    long id;

    @Column(name = "uti_login")
    String username;

    @Column(name = "uti_poids")
    int weight;

    @Column(name = "uti_banni")
    int banned;

    @Column(name = "uti_droi-id")
    long rightId;



}
