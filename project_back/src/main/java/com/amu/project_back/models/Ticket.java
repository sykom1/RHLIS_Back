package com.amu.project_back.models;

import com.amu.project_back.models.enume.TicketDomain;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "ticket_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "ticket_ann_id")
    private transient Directory directory;

    @Column(name = "ticket_nom_prenom")
    private String name;

    @Column(name = "ticket_courriel")
    private String email;

    @OneToOne
    @JoinColumn(name = "ticket_pole_id")
    private transient Pole pole;

    @OneToOne
    @JoinColumn(name = "ticket_equipe_id")
    private transient Team team;

    @Column(name = "ticket_domaine")
    private TicketDomain domain;

    @Column(name = "ticket_description_courte")
    private String shortDesc;

    @Column(name = "ticket_description")
    private String description;

    @Column(name = "ticket_fichier")
    private String file;

    @Column(name = "ticket_date")
    private Date date;
}
