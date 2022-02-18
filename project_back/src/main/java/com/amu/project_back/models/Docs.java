package com.amu.project_back.models;

import com.amu.project_back.models.enume.State;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "annuaire_documents")
@Data
public class Docs {

    @Id
    @GeneratedValue
    @Column(name = "ann_doc_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "ann_doc_ann_id")
    private transient Annuary annuary;

    @Column(name = "ann_doc_titre")
    private String title;

    @Column(name = "ann_doc_description")
    private String description;

    @Column(name = "ann_doc_fichier")
    private String file;

    @Column(name = "ann_doc_date")
    private Date date;

    @Column(name = "ann_doc_etat")
    private State state;


}
