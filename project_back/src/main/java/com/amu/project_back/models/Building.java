package com.amu.project_back.models;

import com.amu.project_back.models.enume.Site;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lis_batiments")
@Data
public class Building {

    @Id
    @GeneratedValue
    @Column(name = "bat_id")
    private long id;

    @Column(name = "bat_label")
    private String name;

    @Column(name = "bat_code")
    private String code;

    @Column(name = "bat_site_id")
    //Ou ID
    private Site site;

}
