package com.amu.project_back.models;

import com.amu.project_back.models.enume.LisDefense;
import com.amu.project_back.models.enume.LisDiploma;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "annuaire_diplome")
@Data
public class Diploma {

    @Id
    @GeneratedValue
    @Column(name = "ann_diplome_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ann_diplome_ann_id")
    private Directory directory;

    @Column(name = "ann_diplome_commentaire")
    private String comment;

    @Column(name = "ann_diplome_titre")
    private String title;

    @Column(name = "ann_diplome_annee")
    private int year;

    @Column(name = "ann_diplome_lieu")
    private String place;

    @Column(name = "lis_diplome")
    private LisDiploma lisDiploma;

    @Column(name = "lis_soutenance")
    private LisDefense lisDefense;

    @Column(name = "ann_sout_titre")
    private String subTitle;

    @Column(name = "ann_sout_date")
    private Date date;

    @Column(name = "ann_sout_fr")
    private String frDef;

    @Column(name = "ann_sout_en")
    private String enDef;


}
