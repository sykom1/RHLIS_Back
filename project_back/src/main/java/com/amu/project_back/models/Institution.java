package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lis_ed")
@Data
public class Institution {
    @Id
    @GeneratedValue
    @Column(name = "lis_ed_id")
    private long id;

    @Column(name = "lis_ed_sigle")
    private String acronym;

    @Column(name = "lis_ed_code_etablissement")
    private String code;

    @Column(name = "lis_ed_etablissement")
    private String name;

    @Column(name = "lis_ed_numero")
    private int number;

    @Column(name = "lis_ed_libelle")
    private String wording;
}
