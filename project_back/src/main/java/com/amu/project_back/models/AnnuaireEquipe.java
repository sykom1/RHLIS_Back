package com.amu.project_back.models;

import com.amu.project_back.models.enume.LisDiploma;
import com.amu.project_back.models.enume.LisStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;


/**
 * The persistent class for the annuaire_equipes database table.
 * 
 */
@Entity
@Data
@Valid
@NoArgsConstructor
@Table(name="annuaire_equipes")
@NamedQuery(name="AnnuaireEquipe.findAll", query="SELECT a FROM AnnuaireEquipe a")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "annuaireEquipesId")
public class AnnuaireEquipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="annuaire_equipes_id")
	private Long annuaireEquipesId;

	@Column(name="ann_bureau")
	private String annBureau;


	@Column(name="ann_tel_pro1")
	private String annTelPro1;

	@Column(name="ann_tel_pro2")
	private String annTelPro2;

	@ManyToOne
	@JoinColumn(name="annuaire_equipes_eq_id")
	private LisEquipe lisEquipe;

	@Temporal(TemporalType.DATE)
	@Column(name="date_arrive")
	private Date dateArrive;

	@Temporal(TemporalType.DATE)
	@Column(name="date_sortie")
	private Date dateSortie;

	@Column(name="lis_responsabilit√©")
	private int lisResponsabilite;

	@Column(name="lis_statut")
	@Enumerated(EnumType.STRING)
	private LisStatus lisStatut;

	@Enumerated(EnumType.STRING)
	private LisDiploma diplome;

	@ManyToOne
	@JoinColumn(name="annuaire_equipes_ann_id")
	private Annuaire annuaire;


	@OneToOne
	@JoinColumn(name = "doctorant_ann_comp_doc_id")
	AnnuaireComplementDoctorant doctorant;



}