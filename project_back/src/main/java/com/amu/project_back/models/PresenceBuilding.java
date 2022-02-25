package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "lis_batiment_presence")
@Data
public class PresenceBuilding {

    @Id
    @GeneratedValue
    @Column(name = "lis_pres_bat_id")
    private long id;

// @Column(name = "")

    @OneToOne
    @JoinColumn(name = "lis_pres_bat_ann_id")
    private transient Directory directory;

    @JoinColumn(name = "lis_pres_bat_bat_id")
    @OneToOne
    private transient Building building;

    @Column(name = "lis_pres_bat_nom")
    private String lastname;

    @Column(name = "lis_pres_bat_prenom")
    private String firstname;

    @Column(name = "lis_pres_bat_jour")
    private Date day;

    @Column(name = "lis_pres_bat_arrivee")
    private Time arrival;

    @Column(name = "lis_pres_bat_depart")
    private Time departure;

    @Column(name = "lis_pres_bat_bureau")
    private String desktop;

    @Column(name = "lis_pres_bat_type")
    private String type;


}
