package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lis_pays")
@Data
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "pays_id")
    private int id;

    @Column(name = "pays_notionalite_fr")
    private String frNationality;

    @Column(name = "pays_label_fr")
    private String frLabel;

    @Column(name = "pays_label_us")
    private String usLabel;

    @Column(name = "pays_iso")
    private String iso;

    @Column(name = "pays_telephone")
    private String phoneNumber;
}
