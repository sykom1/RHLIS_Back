package com.amu.project_back.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Data
@Valid
@NoArgsConstructor
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Utilisateur destinataire;

    private String objet;

    private String message;

    private boolean vu;

    

}
