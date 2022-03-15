package com.amu.project_back.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name = "lis_poles")
@NamedQuery(name="LisPole.findAll", query="SELECT l FROM LisPole l")
public class LisPole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "poles_id")
    private long id;


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