package com.amu.project_back.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name = "lis_poles")
@NamedQuery(name="LisPole.findAll", query="SELECT l FROM LisPole l")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "poleId")
public class LisPole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "poles_id")
    private Long poleId;


    @Column(name="poles_label")
    private String name;

    @ManyToMany()
    @JoinTable(
            name = "lis_poles_equipes",
            joinColumns = @JoinColumn(name = "poles_id"),
            inverseJoinColumns = @JoinColumn(name = "equipes_id")
    )
    private List<LisEquipe> lisEquipes;;


}