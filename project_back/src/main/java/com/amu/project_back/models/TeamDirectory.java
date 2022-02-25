package com.amu.project_back.models;


import com.amu.project_back.models.enume.LisResponsibility;
import com.amu.project_back.models.enume.LisStatus;
import com.amu.project_back.models.enume.TeamRank;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "annuaire_equipes")
@Data
public class TeamDirectory {

    @Id
    @GeneratedValue
    @Column(name = "annuaire_equipes_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "annuaire_equipes_ann_id")
    private transient Directory directory;

    @Column(name = "ann_tel_pro1")
    private String phoneNumber1;

    @Column(name = "ann_tel_pro2")
    private String phoneNumber2;

    @Column(name = "ann_lis_grade")
    private TeamRank rank;

    @Column(name = "ann_bureau")
    private String desktop;

    @Column(name = "date_arrive")
    private Date arrival;

    @Column(name = "date_sortie")
    private Date departure;

    @Column(name = "lis_responsabilité")
    private LisResponsibility responsibility;

    @Column(name = "lis_statut")
    private LisStatus status;


}
