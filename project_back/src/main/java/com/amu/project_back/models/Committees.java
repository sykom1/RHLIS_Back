package com.amu.project_back.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lis_comites")
@Data
public class Committees {
    @Id
    @GeneratedValue
    @Column(name = "lis_com_id")
    private long id;

    @Column(name = "lis_com_label")
    private String label;

    @Column(name = "lis_com_acronyme")
    private String acronym;
}
